package com.mercury.EconomicalInsuranceSystem.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.EconomicalInsuranceSystem.beans.Car;

public interface CarDao extends JpaRepository<Car, Integer> {
	List<Car> findAllByUid(int uid);
}
