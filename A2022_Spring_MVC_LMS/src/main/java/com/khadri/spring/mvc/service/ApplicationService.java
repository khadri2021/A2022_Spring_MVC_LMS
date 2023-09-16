package com.khadri.spring.mvc.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khadri.spring.mvc.dao.CustomerSpringDAO;
import com.khadri.spring.mvc.dto.ApplicationDTO;
import com.khadri.spring.mvc.entity.Customer;

@Service
public class ApplicationService {

	@Autowired
	private CustomerSpringDAO customerSpringDAO;

	public void addApplication(ApplicationDTO appDTO) {

		Function<ApplicationDTO, Customer> convertDtoToEntity = (dto) -> {
			Customer cust = new Customer();
			cust.setFirstName(dto.getFirstName());
			cust.setLastName(dto.getLastName());
			cust.setName(dto.getName());
			cust.setAge(dto.getAge());
			cust.setEmail(dto.getEmail());
			cust.setPhoneNo(dto.getPhoneNo());
			cust.setAlternativePhoneNo(dto.getAlternativePhoneNo());
			cust.setAccountType(dto.getAccountType());
			cust.setCurrentAddress(dto.getCurrentAddress());
			cust.setPermanentAddress(dto.getPermanentAddress());
			cust.setAdhaarNo(dto.getAdhaarNo());
			cust.setPanNo(dto.getPanNo());
			cust.setNomineeName(dto.getNomineeName());
			cust.setNomineeAdhaarNo(dto.getNomineeAdhaarNo());
			cust.setNomineeAcNo(dto.getNomineeAcNo());
			cust.setCibilScore(dto.getCibil());
			return cust;
		};

		Customer customer = Optional.ofNullable(appDTO).stream().map(convertDtoToEntity).findFirst().get();

		customerSpringDAO.insertCustomer(customer);

	}

	public List<ApplicationDTO> getAllCustomers() {

		List<Customer> listOfCustomers = customerSpringDAO.readAllCustomers();

		Function<Customer, ApplicationDTO> convertEntityToDto = (customer) -> {
			ApplicationDTO dto = new ApplicationDTO();

			dto.setFirstName(customer.getFirstName());
			dto.setLastName(customer.getLastName());
			dto.setName(customer.getName());
			dto.setAge(customer.getAge());
			dto.setEmail(customer.getEmail());
			dto.setPhoneNo(customer.getPhoneNo());
			dto.setAlternativePhoneNo(customer.getAlternativePhoneNo());
			dto.setAccountType(customer.getAccountType());
			dto.setCurrentAddress(customer.getCurrentAddress());
			dto.setPermanentAddress(customer.getPermanentAddress());
			dto.setAdhaarNo(customer.getAdhaarNo());
			dto.setPanNo(customer.getPanNo());
			dto.setNomineeName(customer.getNomineeName());
			dto.setNomineeAdhaarNo(customer.getNomineeAdhaarNo());
			dto.setNomineeAcNo(customer.getNomineeAcNo());

			return dto;
		};

		List<ApplicationDTO> listOfcustomersDto = listOfCustomers.stream().map(convertEntityToDto)
				.collect(Collectors.toList());

		return listOfcustomersDto;
	}
	public ApplicationDTO getCustomer(String pan) {

		Customer foundCustomer = customerSpringDAO.readCustomer(pan);

		Function<Customer, ApplicationDTO> convertEntityToDto = (customer) -> {
			ApplicationDTO dto = new ApplicationDTO();
			dto.setFirstName(customer.getFirstName());
			dto.setLastName(customer.getLastName());
			dto.setName(customer.getName());
			dto.setAge(customer.getAge());
			dto.setEmail(customer.getEmail());
			dto.setPhoneNo(customer.getPhoneNo());
			dto.setAlternativePhoneNo(customer.getAlternativePhoneNo());
			dto.setAccountType(customer.getAccountType());
			dto.setCurrentAddress(customer.getCurrentAddress());
			dto.setPermanentAddress(customer.getPermanentAddress());
			dto.setAdhaarNo(customer.getAdhaarNo());
			dto.setPanNo(customer.getPanNo());
			dto.setNomineeName(customer.getNomineeName());
			dto.setNomineeAdhaarNo(customer.getNomineeAdhaarNo());
			dto.setNomineeAcNo(customer.getNomineeAcNo());

			return dto;
		};

		ApplicationDTO applicationDTO = Optional.ofNullable(foundCustomer).stream().map(convertEntityToDto).findFirst().get();

		return applicationDTO;
	}


 
	

	public void modifyCustomer(ApplicationDTO applicationDTO) {

		Function<ApplicationDTO, Customer> convertDtoToEntity = (dto) -> {
			Customer cust = new Customer();
			cust.setFirstName(dto.getFirstName());
			cust.setLastName(dto.getLastName());
			cust.setName(dto.getName());
			cust.setAge(dto.getAge());
			cust.setEmail(dto.getEmail());
			cust.setPhoneNo(dto.getPhoneNo());
			cust.setAlternativePhoneNo(dto.getAlternativePhoneNo());
			cust.setAccountType(dto.getAccountType());
			cust.setCurrentAddress(dto.getCurrentAddress());
			cust.setPermanentAddress(dto.getPermanentAddress());
			cust.setAdhaarNo(dto.getAdhaarNo());
			cust.setPanNo(dto.getPanNo());
			cust.setNomineeName(dto.getNomineeName());
			cust.setNomineeAdhaarNo(dto.getNomineeAdhaarNo());
			cust.setNomineeAcNo(dto.getNomineeAcNo());
			cust.setCibilScore(dto.getCibil());
			return cust;

		};

		Customer customer = Optional.ofNullable(applicationDTO).stream().map(convertDtoToEntity).findFirst().get();

		customerSpringDAO.modifyCustomer(customer);
	}
	public void deleteCustomer(String pan) {

		customerSpringDAO.deleteCustomer(pan);

	}



}
