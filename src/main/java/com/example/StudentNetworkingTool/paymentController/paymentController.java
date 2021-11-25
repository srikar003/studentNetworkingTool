package com.example.StudentNetworkingTool.paymentController;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method = RequestMethod.POST, value = "/addPayment")
	public boolean addPayments(@RequestBody Payment payment) {
		String insertPaymentAdditionQuery = "INSERT INTO payment (transactionId, paymentType, amount, isTransactionSuccessful,studentId,courseId) VALUES (?, ?, ?, ?, ?, ?)";
		try {
			int result = jdbcTemplate.update(insertPaymentAdditionQuery, payment.getTransactionId(), payment.getPaymentType(), payment.getAmount(), payment.isTransactionSuccessful(), payment.getStudentId(), payment.getCourseId());
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
