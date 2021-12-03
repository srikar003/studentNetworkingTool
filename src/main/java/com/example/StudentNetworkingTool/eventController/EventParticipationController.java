package com.example.StudentNetworkingTool.eventController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventParticipationController {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method = RequestMethod.POST, value = "/addParticipantsToEvents")
	public boolean addParticipantsToEvents(@RequestBody EventParticipation eventparticipation) {
		String insertEventParticiaptionAdditionQuery = "INSERT INTO eventParticipation (studentId, eventId) VALUES (?, ?)";
		try {
			int result = jdbcTemplate.update(insertEventParticiaptionAdditionQuery, eventparticipation.getStudentId(),
					eventparticipation.getEventId());
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

	@SuppressWarnings("deprecation")
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method = RequestMethod.POST, value = "/getEventInfo")
	public ResponseEntity<EventInfo> getCourseInfo(@RequestBody EventParticipation ep) {
		boolean isStudentJoined = false;
		String getEventInfoQuery = "select * from eventParticipation where eventId = ? and  studentId = ?";
		try {
			List<EventParticipation> ce = jdbcTemplate.query(getEventInfoQuery,
					new Object[] { ep.getEventId(), ep.getStudentId() }, new RowMapper<EventParticipation>() {
						public EventParticipation mapRow(ResultSet result, int rowNum) throws SQLException {
							EventParticipation e = new EventParticipation(result.getString("eventId"),
									result.getString("studentId"));
							return e;
						}
					});
			if (ce.size() > 0) {
				System.out.println("Data available");
				isStudentJoined = true;
			}
			String getEventInfo = "select * from events where eventId = ?";
			List<Event> event = jdbcTemplate.query(getEventInfo, new Object[] { ep.getEventId() },
					new RowMapper<Event>() {
						public Event mapRow(ResultSet result, int rowNum) throws SQLException {
							Event c = new Event(result.getString("eventId"), result.getString("eventName"),
									result.getString("description"), result.getString("instructorId"));
							return c;
						}
					});
			if (event.size() > 0) {
				EventInfo ei = new EventInfo(event.get(0), isStudentJoined);
				return new ResponseEntity<EventInfo>(ei, HttpStatus.OK);

			} else {
				throw new SQLException("Unable to insert course into db");
			}

		} catch (SQLException sqle) {
			System.out.println(sqle);
			return new ResponseEntity<EventInfo>(HttpStatus.BAD_REQUEST);
		}
	}
}


class EventInfo {
	public Event event;
	public boolean isStudentJoined;

	public EventInfo(Event e, boolean isStudentJoined) {
		event = e;
		this.isStudentJoined = isStudentJoined;
	}
}
