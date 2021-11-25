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
        System.out.println(student);
        String insertStudentRegistrationQuery = "INSERT INTO studentRegistration (userName, password) VALUES (?, ?)";
        String insertStudentInfoQuery = "INSERT INTO students (studentId, firstName, lastName, email, dateOfBirth, college,department, userName) VALUES (?,?,?,?,?,?,?,?)";
        String insertStudentContactsQuery = "INSERT INTO studentContact (contactNo, studentId) VALUES (?, ?)";

        int result = jdbcTemplate.update(insertStudentRegistrationQuery, student.getUserName(), student.getPassword());
        int result1 = jdbcTemplate.update(insertStudentInfoQuery, student.getStudentId(), student.getFirstName(),
                student.getLastName(), student.getEmail(), student.getDob(), student.getCollege(), student.getDept(),
                student.getUserName());
        String[] contactList = student.getContacts();
        for (int i = 0; i < contactList.length; i++) {
            int result2 = jdbcTemplate.update(insertStudentContactsQuery, contactList[i]);
            if (result2 <= 0) {
                return false;
            }
        }
        if (result > 0 && result1 > 0) {
            System.out.println("A new row has been inserted.");
            return true;
        }
        return false;
    }
}
