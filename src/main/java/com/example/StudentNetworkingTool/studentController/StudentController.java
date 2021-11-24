package com.example.StudentNetworkingTool.studentController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method=RequestMethod.POST, value = "/studentRegistration")
	public  boolean studentRegistration(@RequestBody Student p) {
		
        String insertStudentRegistrationQuery = "INSERT INTO studentRegistration (userName, password) VALUES (?, ?)";
        String insertStudentInfoQuery = "INSERT INTO students (studentId, firstName, lastName, email, dateOfBirth, userName) VALUES (?, ?,?,?,?,?)";
        
        UUID corrId = UUID.randomUUID();
        String corrIdAsString = corrId.toString();
        int result = jdbcTemplate.update(insertStudentRegistrationQuery , p.getUserName(),p.getPassword());
         
        int result1 = jdbcTemplate.update(insertStudentInfoQuery ,corrIdAsString, p.getFirstName(),p.getLastName(),p.getEmail(),p.getDob(),p.getUserName());
        if (result > 0 && result1 > 0) {
            System.out.println("A new row has been inserted.");
            return true;
        }
        return false;
	}
}

