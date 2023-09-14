package com.khadri.spring.mvc.DAO;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.khadri.spring.mvc.Entity.CibilEntity;

@Repository
public class CibilDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public String checkCibil(CibilEntity ce) {

		String sql = "select CIBIL_SCORE from cibil_data  where ADHAAR_NUMBER ='" + ce.getaNum() + "' and PAN_NUMBER ='"
				+ ce.getpNum() + "'";
		RowMapper<CibilEntity> rowMapper = rowMapperForCibilScore();
		CibilEntity cen = jdbcTemplate.queryForObject(sql, rowMapper);
		String cibil = cen.getCibilScore();
		Integer cibilScore = Integer.valueOf(cibil);
		if (cibilScore > 60) {
			String sql1 = "update account_data set LOAN_ELIGIBLE ='Eligible' where ADHAAR_NUMBER = ?";
			jdbcTemplate.update(sql1, ce.getaNum());
			return "ELIGIBLE";

		} else {
			String sql1 = "update account_data set LOAN_ELIGIBLE ='INEligible' where ADHAAR_NUMBER = ?";
			jdbcTemplate.update(sql1, ce.getaNum());
			return "INELIGIBLE";

		}

	}

	private RowMapper<CibilEntity> rowMapperForCibilScore() {

		Optional<RowMapper<CibilEntity>> optional = Optional.ofNullable((resultSet, rowNum) -> {
			CibilEntity ce1 = new CibilEntity();

			ce1.setCibilScore(resultSet.getString("CIBIL_SCORE"));

			return ce1;
		});

		return optional.isEmpty() ? null : optional.get();
	}

}
