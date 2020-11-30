package com.mercury.EconomicalInsuranceSystem.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.EconomicalInsuranceSystem.beans.Claim;

public interface ClaimDao extends JpaRepository<Claim, Integer>{
	List<Claim> findAllByUid(int uid);
	List<Claim> findAllByInsurid(int insurid);

}
