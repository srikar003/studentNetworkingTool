package com.example.StudentNetworkingTool.eventController;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
}
