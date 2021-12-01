package com.example.StudentNetworkingTool.queriesController;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueryResponsesController {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method = RequestMethod.POST, value = "/addQueryResponse")
	public boolean addQueryResponse(@RequestBody QueryResponses queryresponse) {
		String insertQueryResponseAdditionQuery = "INSERT INTO queryResponses (instructorId, response, queryId) VALUES (?, ?, ?)";
		try {
			int result = jdbcTemplate.update(insertQueryResponseAdditionQuery, queryresponse.getInstructorId(), queryresponse.getResponse(), queryresponse.getQueryId());
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