package com.khadri.spring.mvc.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.khadri.spring.mvc.entity.Customer;

@Repository
public class CustomerDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public String readEligibility(String accountNumber) {
		String sql = "select LOAN_ELIGIBLE from ACCOUNT_DATA where ACCOUNT_NUMBER='" + accountNumber + "'";

		String eligibility = null;
		try {
			eligibility = jdbcTemplate.queryForObject(sql, rowMapperForEligibility());
		} catch (Exception e) {
			return "Invalid";
		}
		return eligibility;
	}

	private RowMapper<String> rowMapperForEligibility() {

		Optional<RowMapper<String>> optional = Optional.ofNullable((resultSet, rowNum) -> {
			return resultSet.getString("LOAN_ELIGIBLE");
		});
		return optional.isEmpty() ? null : optional.get();
	}

	public Customer readCustomer(String accountNumber) {

		String sql = "select * from ACCOUNT_DATA where ACCOUNT_NUMBER='" + accountNumber + "'";
		RowMapper<Customer> rowMapper = rowMapperForCustomer();
		Customer customer = jdbcTemplate.queryForObject(sql, rowMapper);

		return customer;
	}

	private RowMapper<Customer> rowMapperForCustomer() {

		Optional<RowMapper<Customer>> optional = Optional.ofNullable((resultSet, rowNum) -> {

			Customer customer = new Customer();

			customer.setFirstName(resultSet.getString("FIRST_NAME"));
			customer.setLastName(resultSet.getString("LAST_NAME"));
			customer.setFatherName(resultSet.getString("FATHER_NAME"));
			customer.setAge(resultSet.getString("AGE"));
			customer.setEmail(resultSet.getString("EMAIL"));
			customer.setPhoneNumber(resultSet.getString("PHONE_NUMBER"));
			customer.setAlternativePhoneNumber(resultSet.getString("ALTERNATIVE_PHONE_NUMBER"));
			customer.setAccountType(resultSet.getString("ACCOUNT_TYPE"));
			customer.setCurrentAddress(resultSet.getString("CURRENT_ADDRESS"));
			customer.setPermanentAddress(resultSet.getString("PERMANENT_ADDRESS"));
			customer.setAadhaarNumber(resultSet.getString("ADHAAR_NUMBER"));
			customer.setPanNumber(resultSet.getString("PAN_NUMBER"));
			customer.setNomineeName(resultSet.getString("NOMINEE_NAME"));
			customer.setNomineeAadhaarNumber(resultSet.getString("NOMINEE_ADHAAR_NUMBER"));
			customer.setNomineeAccountNumber(resultSet.getString("NOMINEE_ACCOUNT_NUMBER"));
			customer.setLoanEligible(resultSet.getString("LOAN_ELIGIBLE"));
			customer.setAccountNumber(resultSet.getString("ACCOUNT_NUMBER"));

			return customer;
		});

		return optional.isEmpty() ? null : optional.get();
	}

	public void applyForLoan(Customer customer) {
		String sql = "insert into LOAN_DATA(FIRST_NAME,LAST_NAME,FATHER_NAME,AGE,EMAIL,PHONE_NUMBER,ALTERNATIVE_PHONE_NUMBER,ACCOUNT_TYPE,CURRENT_ADDRESS,PERMANENT_ADDRESS,ADHAAR_NUMBER,PAN_NUMBER,"
				+ "NOMINEE_NAME,NOMINEE_ADHAAR_NUMBER,NOMINEE_ACCOUNT_NUMBER,ACCOUNT_NUMBER,LOAN_ACCOUNT_NUMBER,LOAN_TYPE,ASSETS,HOW_MUCH_LOAN_REQUIRED) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int result = jdbcTemplate.update(sql, customer.getFirstName(), customer.getLastName(), customer.getFatherName(),
				customer.getAge(), customer.getEmail(), customer.getPhoneNumber(), customer.getAlternativePhoneNumber(),
				customer.getAccountType(), customer.getCurrentAddress(), customer.getPermanentAddress(),
				customer.getAadhaarNumber(), customer.getPanNumber(), customer.getNomineeName(),
				customer.getNomineeAadhaarNumber(), customer.getNomineeAccountNumber(), customer.getAccountNumber(),
				customer.getLoanAccountNumber(), customer.getLType(), customer.getAssets(),
				customer.getHowMuchLoanRequired());
		System.out.println(result + " Rows Inserted Successfully");
	}
}
