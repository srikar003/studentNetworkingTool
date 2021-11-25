package com.example.StudentNetworkingTool.paymentController;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardPayment {
	private String cardHolder;
	private String cardNo;
	private int expiryMonth;
	private int expiryYear;
	private int cvv;
	private String transactionId;
	
	public CardPayment(String cardHolder, String cardNo, int expiryMonth, int expiryYear, int cvv,
			String transactionId) {
		super();
		this.cardHolder = cardHolder;
		this.cardNo = cardNo;
		this.expiryMonth = expiryMonth;
		this.expiryYear = expiryYear;
		this.cvv = cvv;
		this.transactionId = transactionId;
	}
	
	public String getCardHolder() {
		return cardHolder;
	}
	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public int getExpiryMonth() {
		return expiryMonth;
	}
	public void setExpiryMonth(int expiryMonth) {
		this.expiryMonth = expiryMonth;
	}
	public int getExpiryYear() {
		return expiryYear;
	}
	public void setExpiryYear(int expiryYear) {
		this.expiryYear = expiryYear;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
}
