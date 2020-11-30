package com.mercury.EconomicalInsuranceSystem.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.EconomicalInsuranceSystem.beans.User;

public interface UserDao extends JpaRepository<User, Integer>{

	User findByUsername(String username);

}
