package com.khadri.spring.mvc.cibil.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.khadri.spring.mvc.cibil.dto.CibilDTO;
import com.khadri.spring.mvc.cibil.form.CibilForm;
import com.khadri.spring.mvc.cibil.service.CibilService;

@Controller
@RequestMapping("cibil")
public class CibilController {

	@Autowired
	private CibilService cs;

	@RequestMapping("/home")
	public String cibilHome(@ModelAttribute("cf") CibilForm cf) {
		return "cibilcheck";
	}

	@RequestMapping("/check")
	public String checkCibil(@Valid @ModelAttribute("cf") CibilForm cf, BindingResult br) {
		if (br.hasErrors()) {
			return "cibilcheck";

		}

		CibilDTO cibilDTO = Optional.ofNullable(cf).stream().map((form) -> {
			CibilDTO dto = new CibilDTO();
			dto.setaNum(form.getaNum());
			dto.setpNum(form.getpNum());
			return dto;
		}).findFirst().get();
		String result = cs.checkCibil(cibilDTO);

		if (result.equalsIgnoreCase("YES")) {

			return "cibilsuccess";

		}

		return "cibilfail";

	}

}
