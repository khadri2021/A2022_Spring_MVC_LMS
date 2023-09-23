package com.khadri.spring.mvc.cibil.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public String cibilHome() {
		return "cibilcheck";
	}

	@RequestMapping("/check")
	@ResponseBody
	public String checkCibil(CibilForm cf) {
		CibilDTO cibilDTO = Optional.ofNullable(cf).stream().map((form) -> {
			CibilDTO dto = new CibilDTO();
			dto.setaNum(form.getaNum());
			dto.setpNum(form.getpNum());
			return dto;
		}).findFirst().get();
		String result = cs.checkCibil(cibilDTO);
		if (result.equalsIgnoreCase("YES")) {
			return "CONGRATULATIONS YOUR ELIGIBLE FOR LOAN";

		}

		return "SORRY YOUR NOT ELIGIBLE FOR LOAN";

	}

}
