package com.mercury.EconomicalInsuranceSystem.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.EconomicalInsuranceSystem.beans.Quote;

public interface QuoteDao extends JpaRepository<Quote, Integer>{

}
