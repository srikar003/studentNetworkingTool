package com.example.StudentNetworkingTool.courseController;

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

import com.example.StudentNetworkingTool.courseController.CourseData;

@RestController
public class CourseController {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method = RequestMethod.POST, value = "/addCourse")
	public boolean addCourse(@RequestBody Course course) {
		String insertCourseAdditionQuery = "INSERT INTO courses (courseId, courseName, isPaidCourse, price, description) VALUES (?, ?, ?, ?, ?)";
		try {
			int result = jdbcTemplate.update(insertCourseAdditionQuery, course.getCourseId(), course.getCourseName(),
					course.isPaidCourse(), course.getPrice(), course.getDescription());
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
	@RequestMapping(method = RequestMethod.POST, value = "/addInstructorsToCourse")
	public boolean addInstructorsToCourse(@RequestBody CourseToInstructor course) {
		String insertCourseToInstructorQuery = "INSERT INTO teaches (courseId, instructorId) VALUES (?, ?)";
		try {
			int result = jdbcTemplate.update(insertCourseToInstructorQuery, course.courseId, course.instructorId);
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
	@RequestMapping(method = RequestMethod.GET, value = "/getCourses")
	public List<CourseData> courseData() {
		String CourseDataQuery = "select firstName,lastName,courseName, description, isPaidCourse, price from instructors as i join courses as c join teaches as t where i.instructorId = t.instructorId and c.courseId=t.courseId";
		List<CourseData> courseList = jdbcTemplate.query(CourseDataQuery, new RowMapper<CourseData>() {
			public CourseData mapRow(ResultSet result, int rowNum) throws SQLException {

				String fullName = result.getString("firstName") + " " + result.getString("lastName");
				CourseData cd = new CourseData(fullName, result.getString("courseName"),
						result.getString("description"), result.getBoolean("isPaidCourse"), result.getInt("price"));
				return cd;
			}
		});
		return courseList;
	}
}

class CourseToInstructor {
	public String instructorId;
	public String courseId;

	public CourseToInstructor(String instructorId, String courseId) {
		this.instructorId = instructorId;
		this.courseId = courseId;
	}
}

class CourseData {
	public String fullName;
	public String courseName;
	public String description;
	public boolean isPaidCourse;
	public int price;

	public CourseData(String fullName, String courseName, String description, boolean isPaidCourse, int price) {
		this.fullName = fullName;
		this.courseName = courseName;
		this.description = description;
		this.isPaidCourse = isPaidCourse;
		this.price = price;
	}
}
