package com.khadri.spring.mvc.utility;

import java.util.Random;

public class LoanAccount {

	public String generateLoanAccountNumber() {
		char[] digits = new char[12];
		for (int i = 0; i < 12; i++) {
			digits[i] = (char) (new Random().nextInt(10) + '0');
		}
		return String.valueOf(digits);
	}

}
