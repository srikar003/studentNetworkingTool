package com.example.StudentNetworkingTool.studentController;

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
    @RequestMapping(method = RequestMethod.POST, value = "/studentRegistration")
    public boolean studentRegistration(@RequestBody Student student) {

        String insertStudentRegistrationQuery = "INSERT INTO studentRegistration (userName, password) VALUES (?, ?)";
        String insertStudentInfoQuery = "INSERT INTO students (studentId, firstName, lastName, email, dateOfBirth, userName) VALUES (?,?,?,?,?,?)";

        int result = jdbcTemplate.update(insertStudentRegistrationQuery, student.getUserName(), student.getPassword());
        int result1 = jdbcTemplate.update(insertStudentInfoQuery, student.getStudentId(), student.getFirstName(),
                student.getLastName(), student.getEmail(), student.getDob(), student.getUserName());
        if (result > 0 && result1 > 0) {
            System.out.println("A new row has been inserted.");
            return true;
        }
        return false;
    }
}
