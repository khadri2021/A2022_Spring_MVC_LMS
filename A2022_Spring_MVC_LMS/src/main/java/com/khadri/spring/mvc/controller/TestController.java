package com.khadri.spring.mvc.controller;

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

import com.khadri.spring.mvc.dto.ApplicationDTO;
import com.khadri.spring.mvc.form.BankForm;
import com.khadri.spring.mvc.service.ApplicationService;
 
 

@Controller
@RequestMapping("form")
public class TestController {

	@Autowired
	private ModelAndView modelAndView;

	@Autowired
	private ApplicationService applicationService;

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
	public String addApplicationForm(BankForm bankForm) {

		Function<BankForm, ApplicationDTO> convertFormToDto = (form) -> {
			ApplicationDTO dto = new ApplicationDTO();
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
			dto.setCibil(form.getCibil());
			return dto;
		};

		ApplicationDTO appDTO = Optional.ofNullable(bankForm).stream().map(convertFormToDto).findFirst().get();

		applicationService.addApplication(appDTO);

		return "inserted record!!!";
	}

	@PostMapping("/modify/register")
	@ResponseBody
	public String modifyCustomerForm(BankForm bankForm) {

		Function<BankForm, ApplicationDTO> convertFormToDto = (form) -> {
			ApplicationDTO dto = new ApplicationDTO();

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
			dto.setCibil(form.getCibil());
			return dto;
		};

		ApplicationDTO applicationDTO = Optional.ofNullable(bankForm).stream().map(convertFormToDto).findFirst().get();

		applicationService.modifyCustomer(applicationDTO);

		return "updated record!!!";
	}

	@RequestMapping("/view/all/registers")
	public ModelAndView viewCustomerForms() {

		List<ApplicationDTO> listOfCustomerssDto = applicationService.getAllCustomers();

		Function<ApplicationDTO, BankForm> convertfromDtoToForm = (dto) -> {
			BankForm form = new BankForm();
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

		List<BankForm> allCustomers = listOfCustomerssDto.stream().map(convertfromDtoToForm)
				.collect(Collectors.toList());

		modelAndView.addObject("edit_result", allCustomers);
		modelAndView.setViewName("modify_customer");

		return modelAndView;
	}

	@GetMapping("/delete/all/registers")
	public ModelAndView deleteCustomerForms() {

		List<ApplicationDTO> listOfCustomersDto = applicationService.getAllCustomers();

		Function<ApplicationDTO, BankForm> convertfromDtoToForm = (dto) -> {
			BankForm form = new BankForm();
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

		List<BankForm> allCustomers = listOfCustomersDto.stream().map(convertfromDtoToForm)
				.collect(Collectors.toList());

		modelAndView.addObject("delete_result", allCustomers);
		modelAndView.setViewName("delete_customer");

		return modelAndView;
	}

	@PostMapping("/delete/register")
	@ResponseBody
	public String deleteCustomerForm(@RequestParam("pan") String pan) {
		applicationService.deleteCustomer(pan);

		return "deleted record!!!";
	}

}
