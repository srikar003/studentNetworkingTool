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
public class ProfessorController {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method = RequestMethod.POST, value = "/addProfessors")
	public boolean addProfessor(@RequestBody Professor professor) {
		String insertProfessorAdditionQuery = "INSERT INTO professors (instructorId, university, dept) VALUES (?, ?)";
		try {
			int result = jdbcTemplate.update(insertProfessorAdditionQuery, professor.getInstructorId(), professor.getUniversity(),professor.getDept());
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
