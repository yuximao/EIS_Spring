package com.mercury.EconomicalInsuranceSystem.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.EconomicalInsuranceSystem.beans.ClaimImage;

public interface ClaimImageDao extends JpaRepository<ClaimImage,Integer>{
	
}
