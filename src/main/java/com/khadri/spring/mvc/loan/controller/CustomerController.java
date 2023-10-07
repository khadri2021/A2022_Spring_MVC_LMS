package com.khadri.spring.mvc.loan.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.khadri.spring.mvc.loan.dto.CustomerDTO;
import com.khadri.spring.mvc.loan.form.AccountForm;
import com.khadri.spring.mvc.loan.form.CustomerForm;
import com.khadri.spring.mvc.loan.service.CustomerService;
import com.khadri.spring.mvc.loan.utility.LoanAccount;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private LoanAccount loanAccount;

	@RequestMapping("loan/homepage")
	public String loanHomePage() {
		return "loanhomepage";
	}

	@RequestMapping("loan/search")
	public String searchPage(@ModelAttribute("accForm") AccountForm accForm) {
		return "search";
	}

	@PostMapping("loan/checkeligibility")
	public String checkEligibility(@Valid @ModelAttribute("accForm") AccountForm accForm, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "search";
		}
		String eligibility = customerService.checkEligibility(accForm.getAccountNumber());
		if (Optional.ofNullable(eligibility).isPresent()) {
			if (eligibility.equalsIgnoreCase("Eligible")) {
				model.addAttribute("accountNumber", accForm.getAccountNumber());
				return "eligible";
			} else if (eligibility.equalsIgnoreCase("InEligible")) {
				return "ineligible";
			}
		}
		return "invalid";
	}

	@GetMapping("loan/createform")
	public String createCustomerLoanApplicationForm(@ModelAttribute("custForm") CustomerForm custForm, Model model) {
		model.addAttribute("custForm",
				Optional.ofNullable(customerService.getCustomer(custForm.getAccountNumber())).stream().map((dto) -> {
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
					form.setLoanAccountNumber(loanAccount.generateLoanAccountNumber());
					return form;
				}).findFirst().get());
		return "apply";
	}

	@PostMapping("loan/process")
	public String afterApply(@Valid @ModelAttribute("custForm") CustomerForm custForm, BindingResult result) {
		if (result.hasErrors()) {
			return "apply";
		}
		String applyForLoan = customerService.applyForLoan(Optional.ofNullable(custForm).stream().map((form) -> {
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
		if (applyForLoan.equalsIgnoreCase("Success")) {
			return "loanapplysuccess";
		}
		return "loanapplyfailed";
	}
}
