package com.khadri.spring.mvc.loan.form;

import javax.validation.constraints.NotEmpty;

public class CustomerForm {

	@NotEmpty(message = "First Name is Empty")
	private String firstName;
	private String lastName;
	private String fatherName;
	@NotEmpty(message = "Age is Empty")
	private String age;
	private String email;
	@NotEmpty(message = "Phone Number is Empty")
	private String phoneNumber;
	private String alternativePhoneNumber;
	@NotEmpty(message = "Account Type is Empty")
	private String accountType;
	@NotEmpty(message = "Current Address is Empty")
	private String currentAddress;
	private String permanentAddress;
	@NotEmpty(message = "Adhaar Number is Empty")
	private String adhaarNumber;
	@NotEmpty(message = "Pan Number is Empty")
	private String panNumber;
	private String nomineeName;
	private String nomineeAdhaarNumber;
	private String nomineeAccountNumber;
	@NotEmpty(message = "Loan Eligible is Empty")
	private String loanEligible;
	@NotEmpty(message = "Account Number is Empty")
	private String accountNumber;
	private String loanAccountNumber;
	@NotEmpty(message = "Loan Type is Empty")
	private String lType;
	@NotEmpty(message = "Assets is Empty")
	private String assets;
	@NotEmpty(message = "Requested Loan Amount is Empty")
	private String howMuchLoanRequired;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAlternativePhoneNumber() {
		return alternativePhoneNumber;
	}

	public void setAlternativePhoneNumber(String alternativePhoneNumber) {
		this.alternativePhoneNumber = alternativePhoneNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getAdhaarNumber() {
		return adhaarNumber;
	}

	public void setAdhaarNumber(String adhaarNumber) {
		this.adhaarNumber = adhaarNumber;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getNomineeName() {
		return nomineeName;
	}

	public void setNomineeName(String nomineeName) {
		this.nomineeName = nomineeName;
	}

	public String getNomineeAdhaarNumber() {
		return nomineeAdhaarNumber;
	}

	public void setNomineeAdhaarNumber(String nomineeAdhaarNumber) {
		this.nomineeAdhaarNumber = nomineeAdhaarNumber;
	}

	public String getNomineeAccountNumber() {
		return nomineeAccountNumber;
	}

	public void setNomineeAccountNumber(String nomineeAccountNumber) {
		this.nomineeAccountNumber = nomineeAccountNumber;
	}

	public String getLoanEligible() {
		return loanEligible;
	}

	public void setLoanEligible(String loanEligible) {
		this.loanEligible = loanEligible;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getLoanAccountNumber() {
		return loanAccountNumber;
	}

	public void setLoanAccountNumber(String loanAccountNumber) {
		this.loanAccountNumber = loanAccountNumber;
	}

	public String getlType() {
		return lType;
	}

	public void setlType(String lType) {
		this.lType = lType;
	}

	public String getAssets() {
		return assets;
	}

	public void setAssets(String assets) {
		this.assets = assets;
	}

	public String getHowMuchLoanRequired() {
		return howMuchLoanRequired;
	}

	public void setHowMuchLoanRequired(String howMuchLoanRequired) {
		this.howMuchLoanRequired = howMuchLoanRequired;
	}
}
