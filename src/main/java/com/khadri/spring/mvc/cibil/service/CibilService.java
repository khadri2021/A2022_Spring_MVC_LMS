package com.khadri.spring.mvc.cibil.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khadri.spring.mvc.cibil.dao.CibilDAO;
import com.khadri.spring.mvc.cibil.dto.CibilDTO;
import com.khadri.spring.mvc.cibil.entity.CibilEntity;

@Service

public class CibilService {
	@Autowired
	private CibilDAO cd;

	public String checkCibil(CibilDTO cdto) {
		CibilEntity cibilEntity = Optional.ofNullable(cdto).stream().map((dto) -> {
			CibilEntity ce = new CibilEntity();
			ce.setaNum(dto.getaNum());
			ce.setpNum(dto.getpNum());
			return ce;
		}).findFirst().get();

		return cd.checkCibil(cibilEntity);

	}

}
