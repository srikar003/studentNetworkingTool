package com.example.StudentNetworkingTool.studentController;

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

import com.example.StudentNetworkingTool.Login;

@RestController
public class StudentController {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method = RequestMethod.POST, value = "/studentRegistration")
	public boolean studentRegistration(@RequestBody Student student) {
		System.out.println(student);
		String insertStudentRegistrationQuery = "INSERT INTO studentRegistration (userName, password) VALUES (?, ?)";
		String insertStudentInfoQuery = "INSERT INTO students (studentId, firstName, lastName, email, dateOfBirth, college,department, userName) VALUES (?,?,?,?,?,?,?,?)";
		String insertStudentContactsQuery = "INSERT INTO studentContact (contactNo, studentId) VALUES (?, ?)";
		try {
			int result = jdbcTemplate.update(insertStudentRegistrationQuery, student.getUserName(),
					student.getPassword());
			int result1 = jdbcTemplate.update(insertStudentInfoQuery, student.getStudentId(), student.getFirstName(),
					student.getLastName(), student.getEmail(), student.getDob(), student.getCollege(),
					student.getDept(), student.getUserName());
			String[] contactList = student.getContacts();

			if (result > 0 && result1 > 0) {
				System.out.println("A new row has been inserted.");
			} else {
				throw new SQLException("unable to insert student data");
			}
			for (int i = 0; i < contactList.length; i++) {
				try {
					System.out.println(contactList[i]);
					int result2 = jdbcTemplate.update(insertStudentContactsQuery, contactList[i].trim(),
							student.getStudentId());
					if (result2 <= 0) {
						throw new SQLException("unable to add contact");
					}
				} catch (SQLException sqle) {
					System.out.println(sqle);
					throw sqle;
				}
			}
			return true;
		} catch (SQLException sqle) {
			return false;
		}
	}

	@SuppressWarnings("deprecation")
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method = RequestMethod.POST, value = "/studentSignIn")
	public ResponseEntity<Login> login(@RequestBody Login loginData) {
		String loginQuery = "select sr.userName as userName, sr.password as password, students.studentId as studentId from studentRegistration sr join students where sr.userName = ? and sr.password =?";
		List<Login> val = jdbcTemplate.query(loginQuery, new Object[] { loginData.userName, loginData.password },
				new RowMapper<Login>() {

					public Login mapRow(ResultSet result, int rowNum) throws SQLException {
						Login ln = new Login(result.getString("userName"), result.getString("password"),
								result.getString("studentId"));
						return ln;
					}
				});

		if (val.size() > 0) {
			System.out.println(val.get(0));
			return new ResponseEntity<Login>(val.get(0), HttpStatus.OK);
		}
		return new ResponseEntity<Login>(HttpStatus.BAD_REQUEST);
	}
}
