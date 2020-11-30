package com.mercury.EconomicalInsuranceSystem.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.EconomicalInsuranceSystem.beans.History;

public interface HistoryDao extends JpaRepository<History, Integer>{
	List<History> findAllByUid(int id);
}
