package com.khadri.spring.mvc.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.khadri.spring.mvc.dto.CustomerDTO;
import com.khadri.spring.mvc.form.CustomerForm;
import com.khadri.spring.mvc.service.CustomerService;
import com.khadri.spring.mvc.utility.LoanAccount;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private ModelAndView modelAndView;

	@Autowired
	private LoanAccount loanAccount;

	@RequestMapping("/")
	public String homePage() {
		return "home";
	}

	@RequestMapping("customer/search")
	public String searchPage() {
		return "search";
	}

	@PostMapping("customer/checkeligibility")
	public ModelAndView checkEligibility(@RequestParam String accountNumber) {
		String eligibility = customerService.checkEligibility(accountNumber);
		if (eligibility.equalsIgnoreCase("ELIGIBLE")) {
			modelAndView.addObject("accountNumber", accountNumber);
			modelAndView.setViewName("eligible");
			return modelAndView;
		} else if (eligibility.equalsIgnoreCase("Invalid")) {
			modelAndView.setViewName("invalid");
			return modelAndView;
		} else

		{
			modelAndView.setViewName("ineligible");
			return modelAndView;
		}
	}

	@GetMapping("customer/createform")
	public ModelAndView createCustomerLoanApplicationForm(@RequestParam String accountNumber) {

		modelAndView.addObject("search_result",
				Optional.ofNullable(customerService.getCustomer(accountNumber)).stream().map((dto) -> {
					CustomerForm form = new CustomerForm();
					form.setFirstName(dto.getFirstName());
					form.setLastName(dto.getLastName());
					form.setFatherName(dto.getFatherName());
					form.setAge(dto.getAge());
					form.setEmail(dto.getEmail());
					form.setPhoneNumber(dto.getPhoneNumber());
					form.setAlternativePhoneNumber(dto.getAlternativePhoneNumber());
					form.setAccountType(dto.getAccountType());
					form.setCurrentAddress(dto.getCurrentAddress());
					form.setPermanentAddress(dto.getPermanentAddress());
					form.setAdhaarNumber(dto.getAadhaarNumber());
					form.setPanNumber(dto.getPanNumber());
					form.setNomineeName(dto.getNomineeName());
					form.setNomineeAdhaarNumber(dto.getNomineeAadhaarNumber());
					form.setNomineeAccountNumber(dto.getNomineeAccountNumber());
					form.setLoanEligible(dto.getLoanEligible());
					form.setAccountNumber(dto.getAccountNumber());
					return form;
				}).findFirst().get()).setViewName("apply");
		modelAndView.addObject("loanAccountNumber", loanAccount.generateLoanAccountNumber());
		return modelAndView;
	}

	@PostMapping("customer/apply")
	@ResponseBody
	public String applyForLoan(CustomerForm customerForm) {
		customerService.applyForLoan(Optional.ofNullable(customerForm).stream().map((form) -> {
			CustomerDTO dto = new CustomerDTO();
			dto.setFirstName(form.getFirstName());
			dto.setLastName(form.getLastName());
			dto.setFatherName(form.getFatherName());
			dto.setAge(form.getAge());
			dto.setEmail(form.getEmail());
			dto.setPhoneNumber(form.getPhoneNumber());
			dto.setAlternativePhoneNumber(form.getAlternativePhoneNumber());
			dto.setAccountType(form.getAccountType());
			dto.setCurrentAddress(form.getCurrentAddress());
			dto.setPermanentAddress(form.getPermanentAddress());
			dto.setAadhaarNumber(form.getAdhaarNumber());
			dto.setPanNumber(form.getPanNumber());
			dto.setNomineeName(form.getNomineeName());
			dto.setNomineeAadhaarNumber(form.getNomineeAdhaarNumber());
			dto.setNomineeAccountNumber(form.getNomineeAccountNumber());
			dto.setLoanEligible(form.getLoanEligible());
			dto.setAccountNumber(form.getAccountNumber());
			dto.setLoanAccountNumber(form.getLoanAccountNumber());
			dto.setLType(form.getlType());
			dto.setAssets(form.getAssets());
			dto.setHowMuchLoanRequired(form.getHowMuchLoanRequired());
			return dto;
		}).findFirst().get());
		return "Successfully Applied For " + customerForm.getlType();
	}
}
