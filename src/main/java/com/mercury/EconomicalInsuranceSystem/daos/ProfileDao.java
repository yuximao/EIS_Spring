package com.mercury.EconomicalInsuranceSystem.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.EconomicalInsuranceSystem.beans.Profile;

public interface ProfileDao extends JpaRepository<Profile, Integer>{
	List<Profile> findAllByUid(int uid);
	
}
