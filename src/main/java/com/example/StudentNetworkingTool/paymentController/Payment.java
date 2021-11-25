package com.example.StudentNetworkingTool.paymentController;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class Payment {
	private String transactionId;
	private String paymentType;
	private double amount;
	private boolean isTransactionSuccessful;
	private String studentId;
	private String courseId;
	public Payment(String transactionId, String paymentType, double amount, boolean isTransactionSuccessful,
			String studentId, String courseId) {
		super();
		this.transactionId = transactionId;
		this.paymentType = paymentType;
		this.amount = amount;
		this.isTransactionSuccessful = isTransactionSuccessful;
		this.studentId = studentId;
		this.courseId = courseId;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public boolean isTransactionSuccessful() {
		return isTransactionSuccessful;
	}
	public void setTransactionSuccessful(boolean isTransactionSuccessful) {
		this.isTransactionSuccessful = isTransactionSuccessful;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
}
