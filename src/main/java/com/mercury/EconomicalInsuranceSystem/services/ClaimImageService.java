package com.mercury.EconomicalInsuranceSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.EconomicalInsuranceSystem.beans.ClaimImage;
import com.mercury.EconomicalInsuranceSystem.daos.ClaimImageDao;
import com.mercury.EconomicalInsuranceSystem.http.Response;

@Service
public class ClaimImageService {
	@Autowired
	private ClaimImageDao cd;
	
	public Response addImage(ClaimImage c){
		cd.save(c);
		return new Response(true);
	}


}
