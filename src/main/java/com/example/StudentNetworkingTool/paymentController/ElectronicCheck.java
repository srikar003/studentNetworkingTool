package com.example.StudentNetworkingTool.paymentController;

public class ElectronicCheck {
	private String accountHolder;
	private String routingNo;
	private String bankName;
	private String branch;
	private String transactionId;
	public ElectronicCheck(String accountHolder, String routingNo, String bankName, String branch,
			String transactionId) {
		super();
		this.accountHolder = accountHolder;
		this.routingNo = routingNo;
		this.bankName = bankName;
		this.branch = branch;
		this.transactionId = transactionId;
	}
	public String getAccountHolder() {
		return accountHolder;
	}
	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}
	public String getRoutingNo() {
		return routingNo;
	}
	public void setRoutingNo(String routingNo) {
		this.routingNo = routingNo;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
}
