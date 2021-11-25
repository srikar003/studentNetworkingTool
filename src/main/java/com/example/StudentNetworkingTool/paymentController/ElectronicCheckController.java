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
public class ElectronicCheckController {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method = RequestMethod.POST, value = "/addElectronicCheckPayment")
	public boolean addElectronicCheckPayments(@RequestBody ElectronicCheck echeckpayment) {
		String insertElectronicCheckPaymentAdditionQuery = "INSERT INTO electroniccheck (transactionId, accountHolder, routingNo, bankName, branch) VALUES (?, ?, ?, ?, ?)";
		try {
			int result = jdbcTemplate.update(insertElectronicCheckPaymentAdditionQuery, echeckpayment.getTransactionId(), echeckpayment.getAccountHolder(), echeckpayment.getRoutingNo(), echeckpayment.getBankName(), echeckpayment.getBranch());
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
