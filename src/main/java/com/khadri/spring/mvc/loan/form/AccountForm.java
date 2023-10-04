package com.khadri.spring.mvc.loan.form;

import javax.validation.constraints.NotEmpty;

public class AccountForm {

	@NotEmpty(message = "Account Number is Empty")
	private String accountNumber;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

}
