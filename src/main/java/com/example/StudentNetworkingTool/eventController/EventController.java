package com.example.StudentNetworkingTool.eventController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method = RequestMethod.POST, value = "/addEvent")
	public boolean addEvents(@RequestBody Event event) {
		String insertEventAdditionQuery = "INSERT INTO events (eventId, eventName, description, instructorId) VALUES (?, ?, ?, ?)";
		try {
			int result = jdbcTemplate.update(insertEventAdditionQuery, event.getEventId(), event.getEventName(),
					event.getDescription(), event.getInstructorId());
			if (result > 0) {
				System.out.println("A new row has been inserted.");
				return true;
			} else {
				throw new SQLException("Unable to insert course into db");
			}
		} catch (SQLException sqle) {
			System.out.println(sqle);
			return false;
		}
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method = RequestMethod.GET, value = "/getEvents")
	public List<EventData> eventData() {
		String EventDataQuery = "select firstName,lastName,eventName from instructors, events where instructors.instructorId = events.instructorId";
		List<EventData> eventList = jdbcTemplate.query(EventDataQuery, new RowMapper<EventData>() {
			public EventData mapRow(ResultSet result, int rowNum) throws SQLException {

				String fullName = result.getString("instructors.firstname") + " "
						+ result.getString("instructors.lastname");
				EventData ed = new EventData(fullName, result.getString("eventName"), result.getString("description"));
				return ed;
			}
		});
		return eventList;
	}
}

class EventData {
	public String fullName;
	public String eventName;
	public String description;

	public EventData(String fullName, String eventName, String description) {
		this.fullName = fullName;
		this.eventName = eventName;
		this.description = description;
	}
}