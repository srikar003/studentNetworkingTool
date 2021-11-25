package com.example.StudentNetworkingTool.instructorController;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InstructorController {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method = RequestMethod.POST, value = "/addIntructors")
	public boolean addInstructors(@RequestBody Instructor instructor) {
		String insertInstructorAdditionQuery = "INSERT INTO instructors (instructorId, teachingExperience, firstName, lastName, email, dateOfBirth, userName) VALUES (?, ?, ?, ?, ?, ?,?)";
		try {
			int result = jdbcTemplate.update(insertInstructorAdditionQuery, instructor.getInstructorId(), instructor.getExp(), instructor.getFirstName(), instructor.getLastName(), instructor.getEmail(), instructor.getDob(), instructor.getUserName());
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
