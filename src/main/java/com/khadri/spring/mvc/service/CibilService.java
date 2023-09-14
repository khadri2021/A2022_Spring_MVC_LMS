package com.khadri.spring.mvc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khadri.spring.mvc.DAO.CibilDAO;
import com.khadri.spring.mvc.DTO.CibilDTO;
import com.khadri.spring.mvc.Entity.CibilEntity;

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
