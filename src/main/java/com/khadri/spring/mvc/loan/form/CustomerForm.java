package com.khadri.spring.mvc.loan.form;

import javax.validation.constraints.NotNull;

public class CustomerForm {

	private String firstName;
	private String lastName;
	private String fatherName;
	private String age;
	private String email;
	private String phoneNumber;
	private String alternativePhoneNumber;
	private String accountType;
	private String currentAddress;
	private String permanentAddress;
	private String adhaarNumber;
	private String panNumber;
	private String nomineeName;
	private String nomineeAdhaarNumber;
	private String nomineeAccountNumber;
	private String loanEligible;
	@NotNull(message = "Account number is empty")
	private String accountNumber;
	private String loanAccountNumber;
	@NotNull
	private String lType;
	@NotNull
	private String assets;
	@NotNull
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
