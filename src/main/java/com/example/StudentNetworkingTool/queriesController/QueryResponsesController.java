package com.example.StudentNetworkingTool.queriesController;

//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//import com.example.StudentNetworkingTool.courseController.Course;
//import com.example.StudentNetworkingTool.courseController.CourseInfo;

@RestController
public class QueryResponsesController {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method = RequestMethod.POST, value = "/addQueryResponse")
	public boolean addQueryResponse(@RequestBody QueryResponses queryresponse) {
		String insertQueryResponseAdditionQuery = "INSERT INTO queryResponses (instructorId, response, queryId) VALUES (?, ?, ?)";
		try {
			int result = jdbcTemplate.update(insertQueryResponseAdditionQuery, queryresponse.getInstructorId(),
					queryresponse.getResponse(), queryresponse.getQueryId());
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

//	@SuppressWarnings("deprecation")
//	@CrossOrigin(origins = "http://localhost:4200")
//	@RequestMapping(method = RequestMethod.POST, value = "/getQueryResponses/{id}")
//	public ResponseEntity<QueryResponses> getQueryResponses() {
//		String getQueryResponsesQuery = "select * from queryResponses where queryId = ?";
//		try {
//			List<QueryResponses> courses = jdbcTemplate.query(getQueryResponsesQuery, new Object[] { obj["queryId"] },
//					new RowMapper<QueryResponses>() {
//						public QueryResponses mapRow(ResultSet result, int rowNum) throws SQLException {
//							QueryResponses c = new QueryResponses(result.getString("instructorId"), result.getString("response"),
//									result.getString("queryId"));
//							return c;
//						}
//					});
//			if (courses.size() > 0) {
//				return new ResponseEntity<QueryResponses>(ci, HttpStatus.OK);
//
//			} else {
//				throw new SQLException("Unable to insert course into db");
//			}
//		} catch (SQLException sqle) {
//			System.out.println(sqle);
//			return new ResponseEntity<QueryResponses>(HttpStatus.BAD_REQUEST);
//		}
//	}
}