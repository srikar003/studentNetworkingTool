package com.example.StudentNetworkingTool.courseController;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CourseEnrollmentController {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method = RequestMethod.POST, value = "/enrollCourse")
	public boolean addEvents(@RequestBody CourseEnrollment courseEnrollment) {
		String insertCourseEnrollmentQuery = "INSERT INTO courseEnrollment (courseId, studentId) VALUES (?, ?)";
		try {
			int result = jdbcTemplate.update(insertCourseEnrollmentQuery, courseEnrollment.getCourseId(), courseEnrollment.getStudentId());
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
