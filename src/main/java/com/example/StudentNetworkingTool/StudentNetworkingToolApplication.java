package com.example.StudentNetworkingTool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
@RestController
public class StudentNetworkingToolApplication  implements CommandLineRunner{

    @Autowired
    private JdbcTemplate jdbcTemplate;
     
    public static void main(String[] args) {
        SpringApplication.run(StudentNetworkingToolApplication.class, args);
    }
 
    @Override
    public void run(String... args) throws Exception {
        String sql = "INSERT INTO actor (actor_id, first_name, last_name) VALUES (?, ?, ?)";
         
        int result = jdbcTemplate.update(sql, 201, "ravi", "kumar");
         
        if (result > 0) {
            System.out.println("A new row has been inserted.");
        }
         
    }

	@GetMapping("/hello")
		public String hello() {
		return "Hello Worlds";
	}
}
