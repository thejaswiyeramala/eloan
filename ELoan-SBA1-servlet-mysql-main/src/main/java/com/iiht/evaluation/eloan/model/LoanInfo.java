package com.iiht.evaluation.eloan.model;

public class LoanInfo {
	private String loanName;
	 private String ApplicationNumber;
	 private int AmountRequest;
	 private String ApplicationDate;
	 private String BusinessStructure;
	 private String BillingIndicator;
	 private String TaxIndicator;
	private String Address;
	 private String MobileNumber;
	 private String EmailID;
	 private String Status;
	 @Override
		public String toString() {
			return "LoanInfo [ApplicationNumber=" + ApplicationNumber + ", loanName=" + loanName + ", AmountRequest=" + AmountRequest + ", ApplicationDate=" + ApplicationDate
					+ ", BusinessStructure=" + BusinessStructure + ", BillingIndicator=" + BillingIndicator + ",TaxIndicator="+TaxIndicator +", Address=" + Address + ", EmailID="
					+ EmailID + ", MobileNumber=" + MobileNumber + ", Status=" + Status + "]";
		}
	 public LoanInfo() {
		 
	 }
	 public LoanInfo(String ApplicationNumber, String loanName, int AmountRequest, String ApplicationDate, String BusinessStructure, String BillingIndicator,String TaxIndicator,
			String Address, String EmailID, String MobileNumber,String Status) {
		super();
		this.ApplicationNumber = ApplicationNumber;
		this.loanName = loanName;
		this.AmountRequest = AmountRequest;
		this.ApplicationDate = ApplicationDate;
		this.BusinessStructure = BusinessStructure;
		this.BillingIndicator = BillingIndicator;
		this.TaxIndicator=TaxIndicator;
		this.Address = Address;
		this.EmailID = EmailID;
		this.MobileNumber = MobileNumber;
		this.Status=Status;
	}
	public String getLoanName() {
		return loanName;
	}
	public void setLoanName(String loanName) {
		this.loanName = loanName;
	}
	public String getApplicationNumber() {
		return ApplicationNumber;
	}
	public void setApplicationNumber(String ApplicationNumber) {
		this.ApplicationNumber = ApplicationNumber;
	}
	public int getAmountRequest() {
		return AmountRequest;
	}
	public void setAmountRequest(int AmountRequest) {
		this.AmountRequest = AmountRequest;
	}
	public String getApplicationDate() {
		return ApplicationDate;
	}
	public void setApplicationDate(String ApplicationDate) {
		this.ApplicationDate = ApplicationDate;
	}
	public String getBusinessStructure() {
		return BusinessStructure;
	}
	public void setBusinessStructure(String BusinessStructure) {
		this.BusinessStructure = BusinessStructure;
	}
	public String getBillingIndicator() {
		return BillingIndicator;
	}
	public void setBillingIndicator(String BillingIndicator) {
		this.BillingIndicator = BillingIndicator;
	}
	public String getTaxIndicator() {
		return TaxIndicator;
	}
	public void setTaxIndicator(String TaxIndicator) {
		this.TaxIndicator = TaxIndicator;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String Address) {
		this.Address = Address;
	}
	public String getMobileNumber() {
		return MobileNumber;
	}
	public void setMobileNumber(String MobileNumber) {
		this.MobileNumber = MobileNumber;
	}
	public String getEmailID() {
		return EmailID;
	}
	public void setEmailID(String EmailID) {
		this.EmailID = EmailID;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String Status) {
		this.Status = Status;
	}


}
