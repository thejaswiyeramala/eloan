package com.iiht.evaluation.eloan.model;

public class Loan {
	
	private String applicationNum;
	private String applicationName;
	public Loan() {
		
	}
	public String getapplicationNum() {
		return applicationNum;
	}
	public void setapplicationNum(String applicationNum) {
		this.applicationNum = applicationNum;
	}
	public String getapplicationName() {
		return applicationName;
	}
	public void setapplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
	public Loan(String applicationNum, String applicationName) {
		super();
		this.applicationNum = applicationNum;
		this.applicationName = applicationName;
	}
	

}
