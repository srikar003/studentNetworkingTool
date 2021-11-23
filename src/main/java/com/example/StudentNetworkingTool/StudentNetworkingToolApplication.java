package com.example.StudentNetworkingTool;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
@RestController
public class StudentNetworkingToolApplication{

    @Autowired
    private JdbcTemplate jdbcTemplate;
     
    public static void main(String[] args) {
        SpringApplication.run(StudentNetworkingToolApplication.class, args);
    }
 
    @GetMapping("/run")
    public void run(String... args){
        String sql = "INSERT INTO courses (courseId, courseName, isPaidResource) VALUES (?, ?, ?)";
        
        UUID corrId = UUID.randomUUID();
        String corrIdAsString = corrId.toString();
        System.out.println(corrIdAsString.length());
        int result = jdbcTemplate.update(sql,corrIdAsString , "Java", false);
         
        if (result > 0) {
            System.out.println("A new row has been inserted.");
        }
         
    }
}
