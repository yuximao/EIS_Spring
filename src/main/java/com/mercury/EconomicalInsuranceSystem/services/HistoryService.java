package com.mercury.EconomicalInsuranceSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.EconomicalInsuranceSystem.beans.History;
import com.mercury.EconomicalInsuranceSystem.daos.HistoryDao;
import com.mercury.EconomicalInsuranceSystem.http.Response;

@Service
public class HistoryService {
	@Autowired
	private HistoryDao hd;
	
	public Response addHistory(History h){
		hd.save(h);
		return new Response(true);
	}
	public List<History> getbyUser(int id){
		return hd.findAllByUid(id);
	}
	
}
