package com.mercury.EconomicalInsuranceSystem.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.EconomicalInsuranceSystem.beans.Insurance;

public interface InsuranceDao extends JpaRepository<Insurance, Integer>{
	List<Insurance> findAllByUid(int uid);
}
