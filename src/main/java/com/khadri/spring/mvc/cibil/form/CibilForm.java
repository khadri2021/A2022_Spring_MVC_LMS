package com.khadri.spring.mvc.cibil.form;

import javax.validation.constraints.NotEmpty;

public class CibilForm {
	@NotEmpty(message = "Aadhar Number is Empty")
	private String aNum;
	@NotEmpty(message = "PAN Number is Empty")
	private String pNum;
	public String getaNum() {
		return aNum;
	}
	public void setaNum(String aNum) {
		this.aNum = aNum;
	}
	public String getpNum() {
		return pNum;
	}
	public void setpNum(String pNum) {
		this.pNum = pNum;
	}
	
}
