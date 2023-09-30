package com.khadri.spring.mvc.loan.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khadri.spring.mvc.loan.dao.CustomerDAO;
import com.khadri.spring.mvc.loan.dto.CustomerDTO;
import com.khadri.spring.mvc.loan.entity.Customer;

@Service
public class CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	public String checkEligibility(String accountNumber) {
		return customerDAO.readEligibility(accountNumber);
	}

	public CustomerDTO getCustomer(String accountNumber) {

		return Optional.ofNullable(customerDAO.readCustomer(accountNumber)).stream().map((customer) -> {
			CustomerDTO dto = new CustomerDTO();
			dto.setFirstName(customer.getFirstName());
			dto.setLastName(customer.getLastName());
			dto.setFatherName(customer.getFatherName());
			dto.setAge(customer.getAge());
			dto.setEmail(customer.getEmail());
			dto.setPhoneNumber(customer.getPhoneNumber());
			dto.setAlternativePhoneNumber(customer.getAlternativePhoneNumber());
			dto.setAccountType(customer.getAccountType());
			dto.setCurrentAddress(customer.getCurrentAddress());
			dto.setPermanentAddress(customer.getPermanentAddress());
			dto.setAadhaarNumber(customer.getAadhaarNumber());
			dto.setPanNumber(customer.getPanNumber());
			dto.setNomineeName(customer.getNomineeName());
			dto.setNomineeAadhaarNumber(customer.getNomineeAadhaarNumber());
			dto.setNomineeAccountNumber(customer.getNomineeAccountNumber());
			dto.setLoanEligible(customer.getLoanEligible());
			dto.setAccountNumber(customer.getAccountNumber());
			return dto;
		}).findFirst().get();
	}

	public String applyForLoan(CustomerDTO customerDTO) {
		Customer cust = Optional.ofNullable(customerDTO).stream().map((dto) -> {
			Customer customer = new Customer();
			customer.setFirstName(dto.getFirstName());
			customer.setLastName(dto.getLastName());
			customer.setFatherName(dto.getFatherName());
			customer.setAge(dto.getAge());
			customer.setEmail(dto.getEmail());
			customer.setPhoneNumber(dto.getPhoneNumber());
			customer.setAlternativePhoneNumber(dto.getAlternativePhoneNumber());
			customer.setAccountType(dto.getAccountType());
			customer.setCurrentAddress(dto.getCurrentAddress());
			customer.setPermanentAddress(dto.getPermanentAddress());
			customer.setAadhaarNumber(dto.getAadhaarNumber());
			customer.setPanNumber(dto.getPanNumber());
			customer.setNomineeName(dto.getNomineeName());
			customer.setNomineeAadhaarNumber(dto.getNomineeAadhaarNumber());
			customer.setNomineeAccountNumber(dto.getNomineeAccountNumber());
			customer.setLoanEligible(dto.getLoanEligible());
			customer.setAccountNumber(dto.getAccountNumber());
			customer.setLoanAccountNumber(dto.getLoanAccountNumber());
			customer.setLType(dto.getLType());
			customer.setAssets(dto.getAssets());
			customer.setHowMuchLoanRequired(dto.getHowMuchLoanRequired());
			return customer;
		}).findFirst().get();
		return customerDAO.applyForLoan(cust);
	}

}
