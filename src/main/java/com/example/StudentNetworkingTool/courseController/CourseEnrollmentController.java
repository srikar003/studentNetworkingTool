package com.example.StudentNetworkingTool.courseController;

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
public class CourseEnrollmentController {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method = RequestMethod.POST, value = "/enrollCourse")
	public Object enrollCourse(@RequestBody CourseEnrollment courseEnrollment) {
		String insertCourseEnrollmentQuery = "INSERT INTO enrollment (courseId, studentId) VALUES (?, ?)";
		try {
			int result = jdbcTemplate.update(insertCourseEnrollmentQuery, courseEnrollment.getCourseId(),
					courseEnrollment.getStudentId());
			if (result > 0) {
				System.out.println("A new row has been inserted.");
				return new ResponseEntity<Boolean>(true, HttpStatus.OK);
			} else {
				throw new SQLException("Unable to insert course into db");
			}
		} catch (SQLException sqle) {
			System.out.println(sqle);
			return new ResponseEntity<CourseEnrollment>(HttpStatus.BAD_REQUEST);
		}
	}

	@SuppressWarnings("deprecation")
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method = RequestMethod.POST, value = "/getCourseInfo")
	public ResponseEntity<CourseInfo> getCourseInfo(@RequestBody CourseEnrollment courseEnrollment) {
		boolean isStudentRegistered = false;
		String getCourseInfoQuery = "select * from enrollment where courseId = ? and  studentId = ?";
		try {
			List<CourseEnrollment> ce = jdbcTemplate.query(getCourseInfoQuery,
					new Object[] { courseEnrollment.getCourseId(), courseEnrollment.getStudentId() },
					new RowMapper<CourseEnrollment>() {
						public CourseEnrollment mapRow(ResultSet result, int rowNum) throws SQLException {
							CourseEnrollment c = new CourseEnrollment(result.getString("courseId"), result.getString("studentId"));
							return c;
						}
					});
			if (ce.size() > 0) {
				System.out.println("Data available");
				isStudentRegistered = true;
			}
			String getCourseInfo = "select * from courses where courseId = ?";
			List<Course> courses = jdbcTemplate.query(getCourseInfo, new Object[] { courseEnrollment.getCourseId() },
					new RowMapper<Course>() {
						public Course mapRow(ResultSet result, int rowNum) throws SQLException {
							Course c = new Course(result.getString("courseId"), result.getString("courseName"),
									result.getBoolean("isPaidCourse"), result.getDouble("price"),
									result.getString("description"));
							return c;
						}
					});
			if (courses.size() > 0) {
				CourseInfo ci = new CourseInfo(courses.get(0), isStudentRegistered);
				return new ResponseEntity<CourseInfo>(ci, HttpStatus.OK);

			} else {
				throw new SQLException("Unable to insert course into db");
			}

		} catch (SQLException sqle) {
			System.out.println(sqle);
			return new ResponseEntity<CourseInfo>(HttpStatus.BAD_REQUEST);
		}
	}
}

class CourseInfo {
	public Course course;
	public boolean isStudentRegistered;

	public CourseInfo(Course c, boolean isStudentRegistered) {
		course = c;
		this.isStudentRegistered = isStudentRegistered;
	}
}
