package com.khadri.spring.mvc.account.controller;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.khadri.spring.mvc.account.dto.AccountDTO;
import com.khadri.spring.mvc.account.entity.Account;
import com.khadri.spring.mvc.account.form.AccountForm;
import com.khadri.spring.mvc.account.service.AccountService;
import com.khadri.spring.mvc.account.utility.AccountNumber;

@Controller
@RequestMapping("form")
public class AccountController {

	@Autowired
	private ModelAndView modelAndView;

	@Autowired
	private AccountService accountService;

	@GetMapping("/adminpage")
	public String bankAdminPage() {
		return "form_admin";
	}

	@GetMapping("/addpage")
	public String addApplicationForm() {
		return "add_form";
	}

	@GetMapping("/viewpage")
	public String viewCustomerPage() {
		return "view_customer";
	}

	@PostMapping("/add/register")
	@ResponseBody
	public String addApplicationForm(AccountForm accountForm) {

		Function<AccountForm, AccountDTO> convertFormToDto = (form) -> {
			AccountDTO dto = new AccountDTO();
			dto.setFirstName(form.getfName());
			dto.setLastName(form.getlName());
			dto.setName(form.getName());
			dto.setAge(form.getsAge());
			dto.setEmail(form.getEmail());
			dto.setPhoneNo(form.getPhone());
			dto.setAlternativePhoneNo(form.getAlterPhone());
			dto.setAccountType(form.getType());
			dto.setCurrentAddress(form.getcAddress());
			dto.setPermanentAddress(form.getpAddress());
			dto.setAdhaarNo(form.getAdhaar());
			dto.setPanNo(form.getPan());
			dto.setNomineeName(form.getnName());
			dto.setNomineeAdhaarNo(form.getAno());
			dto.setNomineeAcNo(form.getAno());
			dto.setAccountNumber(AccountNumber.generateAccountNumber());
			dto.setCibil(form.getCibil());
			return dto;
		};

		AccountDTO accDTO = Optional.ofNullable(accountForm).stream().map(convertFormToDto).findFirst().get();

		accountService.addApplication(accDTO);

		return "inserted record!!!";
	}

	@PostMapping("/modify/register")
	@ResponseBody
	public String modifyAccountForm(AccountForm accountForm) {

		Function<AccountForm, AccountDTO> convertFormToDto = (form) -> {
			AccountDTO dto = new AccountDTO();

			dto.setFirstName(form.getfName());
			dto.setLastName(form.getlName());
			dto.setName(form.getName());
			dto.setAge(form.getsAge());
			dto.setEmail(form.getEmail());
			dto.setPhoneNo(form.getPhone());
			dto.setAlternativePhoneNo(form.getAlterPhone());
			dto.setAccountType(form.getType());
			dto.setCurrentAddress(form.getcAddress());
			dto.setPermanentAddress(form.getpAddress());
			dto.setAdhaarNo(form.getAdhaar());
			dto.setPanNo(form.getPan());
			dto.setNomineeName(form.getnName());
			dto.setNomineeAdhaarNo(form.getAno());
			dto.setNomineeAcNo(form.getAco());
			dto.setCibil(form.getCibil());
			return dto;
		};

		AccountDTO accountDTO = Optional.ofNullable(accountForm).stream().map(convertFormToDto).findFirst().get();

		accountService.modifyAccount(accountDTO);

		return "updated record!!!";
	}

	@RequestMapping("/view/all/registers")
	public ModelAndView viewAccountForms() {

		List<AccountDTO> listOfAccountsDto = accountService.getAllAccounts();

		Function<AccountDTO, AccountForm> convertfromDtoToForm = (dto) -> {
			AccountForm form = new AccountForm();
			form.setfName(dto.getFirstName());
			form.setlName(dto.getLastName());
			form.setName(dto.getName());
			form.setsAge(dto.getAge());
			form.setEmail(dto.getEmail());
			form.setPhone(dto.getPhoneNo());
			form.setAlterPhone(dto.getAlternativePhoneNo());
			form.setType(dto.getAccountType());
			form.setcAddress(dto.getCurrentAddress());
			form.setpAddress(dto.getPermanentAddress());
			form.setAdhaar(dto.getAdhaarNo());
			form.setPan(dto.getPanNo());
			form.setnName(dto.getNomineeName());
			form.setAno(dto.getNomineeAdhaarNo());
			form.setAco(dto.getNomineeAcNo());
			form.setCibil(dto.getCibil());
			return form;
		};

		List<AccountForm> allAccounts = listOfAccountsDto.stream().map(convertfromDtoToForm)
				.collect(Collectors.toList());

		modelAndView.addObject("edit_result", allAccounts);
		modelAndView.setViewName("modify_customer");

		return modelAndView;
	}

	@GetMapping("/delete/all/registers")
	public ModelAndView deleteAccountForms() {

		List<AccountDTO> listOfAccountsDto = accountService.getAllAccounts();

		Function<AccountDTO, AccountForm> convertfromDtoToForm = (dto) -> {
			AccountForm form = new AccountForm();
			form.setfName(dto.getFirstName());
			form.setlName(dto.getLastName());
			form.setName(dto.getName());
			form.setsAge(dto.getAge());
			form.setEmail(dto.getEmail());
			form.setPhone(dto.getPhoneNo());
			form.setAlterPhone(dto.getAlternativePhoneNo());
			form.setType(dto.getAccountType());
			form.setcAddress(dto.getCurrentAddress());
			form.setpAddress(dto.getPermanentAddress());
			form.setAdhaar(dto.getAdhaarNo());
			form.setPan(dto.getPanNo());
			form.setnName(dto.getNomineeName());
			form.setAno(dto.getNomineeAdhaarNo());
			form.setAco(dto.getNomineeAcNo());
			form.setCibil(dto.getCibil());
			return form;
		};

		List<AccountForm> allAccounts = listOfAccountsDto.stream().map(convertfromDtoToForm)
				.collect(Collectors.toList());

		modelAndView.addObject("delete_result", allAccounts);
		modelAndView.setViewName("delete_customer");

		return modelAndView;
	}

	@PostMapping("/delete/register")
	@ResponseBody
	public String deleteCustomerForm(@RequestParam("pan") String pan) {
		accountService.deleteAccount(pan);

		return "deleted record!!!";
	}
	@GetMapping("/view/register")
	@ResponseBody
	public ModelAndView viewCustomerForm(@RequestParam("pan") String pan) {
		modelAndView.addObject("view_result", accountService.viewAccount(pan));
		modelAndView.setViewName("view_customer");

		return modelAndView;

		
		
	}

}
