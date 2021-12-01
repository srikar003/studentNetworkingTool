package com.example.StudentNetworkingTool.instructorController;

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
public class InstructorController {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method = RequestMethod.POST, value = "/instructorRegistration")
	public boolean addInstructors(@RequestBody Instructor instructor) {
		String insertInstructorRegistrationQuery = "INSERT INTO instructorRegistration (userName, password) VALUES (?, ?)";
		String insertInstructorInfoQuery = "INSERT INTO instructors (instructorId, teachingExperience, firstName, lastName, email, dateOfBirth, userName) VALUES (?, ?, ?, ?, ?, ?,?)";
		String insertInstructorContactsQuery = "INSERT INTO instructorContact (contactNo, instructorId) VALUES (?,?)";
		try {
			int result = jdbcTemplate.update(insertInstructorRegistrationQuery, instructor.getUserName(),
					instructor.getPassword());
			int result1 = jdbcTemplate.update(insertInstructorInfoQuery, instructor.getInstructorId(),
					instructor.getExp(), instructor.getFirstName(), instructor.getLastName(), instructor.getEmail(),
					instructor.getDob(), instructor.getUserName());
			String[] contactList = instructor.getContacts();

			if (result > 0 && result1 > 0) {
				System.out.println("A new row has been inserted.");
			} else {
				throw new SQLException("unable to insert instructor data");
			}
			for (int i = 0; i < contactList.length; i++) {
				try {
					System.out.println(contactList[i]);
					int result2 = jdbcTemplate.update(insertInstructorContactsQuery, contactList[i].trim(),
							instructor.getInstructorId());
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
	@RequestMapping(method = RequestMethod.POST, value = "/instructorSignIn")
	public ResponseEntity<Login> login(@RequestBody Login loginData) {
		String loginQuery = "select ir.userName as userName, ir.password as password, instructorId from instructorRegistration as ir join instructors where ir.userName = ? and ir.password =?";
		List<Login> val = jdbcTemplate.query(loginQuery, new Object[] { loginData.userName, loginData.password },
				new RowMapper<Login>() {

					public Login mapRow(ResultSet result, int rowNum) throws SQLException {
						Login ln = new Login(result.getString("userName"), result.getString("password"),
								result.getString("instructorId"));
						return ln;
					}
				});
		if (val.size() > 0) {
			return new ResponseEntity<Login>(val.get(0), HttpStatus.OK);
		}
		return new ResponseEntity<Login>(HttpStatus.BAD_REQUEST);
	}
}
