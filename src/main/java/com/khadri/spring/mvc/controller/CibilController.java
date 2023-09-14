package com.khadri.spring.mvc.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.khadri.spring.mvc.DTO.CibilDTO;
import com.khadri.spring.mvc.Form.CibilForm;
import com.khadri.spring.mvc.service.CibilService;

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
		if (result.equalsIgnoreCase("ELIGIBLE")) {
			return "CONGRATULATIONS YOUR ELIGIBLE FOR LOAN";

		}

		return "SORRY YOUR NOT ELIGIBLE FOR LOAN";

	}

}
