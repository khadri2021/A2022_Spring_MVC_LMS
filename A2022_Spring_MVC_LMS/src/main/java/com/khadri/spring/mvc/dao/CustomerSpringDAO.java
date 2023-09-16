package com.khadri.spring.mvc.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.khadri.spring.mvc.entity.Customer;

@Repository
public class CustomerSpringDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// insert student record
	public void insertCustomer(Customer customer) {
		System.out.println("Entered into CustomerSpringDao : insertCustomer(-)");

		String sql = "insert into ACCOUNT_DATA(FIRST_NAME,LAST_NAME,FATHER_NAME,AGE,EMAIL,PHONE_NUMBER,ALTERNATIVE_PHONE_NUMBER,ACCOUNT_TYPE,CURRENT_ADDRESS,PERMANENT_ADDRESS,ADHAAR_NUMBER,PAN_NUMBER,NOMINEE_NAME,NOMINEE_ADHAAR_NUMBER,NOMINEE_ACCOUNT_NUMBER) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		String sql1 = "insert into CIBIL_DATA values(?,?,?) ";

		int result = jdbcTemplate.update(sql, customer.getFirstName(), customer.getLastName(), customer.getName(),
				customer.getAge(), customer.getEmail(), customer.getPhoneNo(), customer.getAlternativePhoneNo(),
				customer.getAccountType(), customer.getCurrentAddress(), customer.getPermanentAddress(),
				customer.getAdhaarNo(), customer.getPanNo(), customer.getNomineeName(), customer.getNomineeAdhaarNo(),
				customer.getNomineeAcNo());

		int result1 = jdbcTemplate.update(sql1, customer.getAdhaarNo(), customer.getPanNo(), customer.getCibilScore());

		System.out.println(result + " Rows Inserted Successfully in customer_register");
		System.out.println(result1 + " Rows Inserted Successfully in CIBIL_DATA");

	}

	public List<Customer> readAllCustomers() {
		System.out.println("Entered into CustomerSpringDao : readAllCustomers(-)");

		String sql = "select * from ACCOUNT_DATA";
		RowMapper<Customer> rowMapper = rowMapperForCustomer();
		List<Customer> listOfStudent = jdbcTemplate.query(sql, rowMapper);

		return listOfStudent;

	}

	public void modifyCustomer(Customer customer) {
		System.out.println("Entered into StudentSpringDao : modifyCustomer(-)");

		String sql = "update ACCOUNT_DATA set LAST_NAME=?,FATHER_NAME=?,AGE=?,EMAIL=?,PHONE_NUMBER=?,ALTERNATIVE_PHONE_NUMBER=?,ACCOUNT_TYPE=?,CURRENT_ADDRESS=?,PERMANENT_ADDRESS=?,ADHAAR_NUMBER=?,PAN_NUMBER=?,NOMINEE_NAME=?,NOMINEE_ADHAAR_NUMBER=?,NOMINEE_ACCOUNT_NUMBER=? where FIRST_NAME=?;";
		int result = jdbcTemplate.update(sql, customer.getLastName(), customer.getName(), customer.getAge(),
				customer.getEmail(), customer.getPhoneNo(), customer.getAlternativePhoneNo(), customer.getAccountType(),
				customer.getCurrentAddress(), customer.getPermanentAddress(), customer.getAdhaarNo(), customer.getPanNo(),
				customer.getNomineeName(), customer.getNomineeAdhaarNo(), customer.getNomineeAcNo(),customer.getFirstName());
		System.out.println(result + " Rows Updated Successfully");

	}
	public Customer readCustomer(String pan) {
		System.out.println("Entered into CustomerSpringDao : readCustomer(-)");

		String sql = "select * from ACCOUNT_DATA where PAN_NUMBER='" + pan +"'";
		RowMapper<Customer> rowMapper = rowMapperForCustomer();
		Customer student = jdbcTemplate.queryForObject(sql, rowMapper);

		return student;
	}


	private RowMapper<Customer> rowMapperForCustomer() {

		Optional<RowMapper<Customer>> optional = Optional.ofNullable((resultSet, rowNum) -> {
			Customer cust = new Customer();

			cust.setFirstName(resultSet.getString("FIRST_NAME"));
			cust.setLastName(resultSet.getString("LAST_NAME"));
			cust.setName(resultSet.getString("FATHER_NAME"));
			cust.setAge(resultSet.getString("AGE"));
			cust.setEmail(resultSet.getString("EMAIL"));
			cust.setPhoneNo(resultSet.getString("PHONE_NUMBER"));
			cust.setAlternativePhoneNo(resultSet.getString("ALTERNATIVE_PHONE_NUMBER"));
			cust.setAccountType(resultSet.getString("ACCOUNT_TYPE"));
			cust.setCurrentAddress(resultSet.getString("CURRENT_ADDRESS"));
			cust.setPermanentAddress(resultSet.getString("PERMANENT_ADDRESS"));
			cust.setAdhaarNo(resultSet.getString("ADHAAR_NUMBER"));
			cust.setPanNo(resultSet.getString("PAN_NUMBER"));
			cust.setNomineeName(resultSet.getString("NOMINEE_NAME"));
			cust.setNomineeAdhaarNo(resultSet.getString("NOMINEE_ADHAAR_NUMBER"));
			cust.setNomineeAcNo(resultSet.getString("NOMINEE_ACCOUNT_NUMBER"));

			return cust;
		});

		return optional.isEmpty() ? null : optional.get();
	}

	public void deleteCustomer(String panNo) {
		System.out.println("Entered into CustomerSpringDao : deleteCustomer(-)");

		String sql = "delete from ACCOUNT_DATA where PAN_NUMBER=" + panNo;
		int result = jdbcTemplate.update(sql);
		System.out.println(result + " Record deleted ");
	}

}
