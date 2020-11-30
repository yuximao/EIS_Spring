package com.mercury.EconomicalInsuranceSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.EconomicalInsuranceSystem.beans.ClaimImage;
import com.mercury.EconomicalInsuranceSystem.http.Response;
import com.mercury.EconomicalInsuranceSystem.services.ClaimImageService;

@RestController
@RequestMapping("/claimimage")
public class ClaimImageController {
	@Autowired
	private ClaimImageService cs;
	
	@PostMapping
	public Response saveImage(@RequestBody ClaimImage c){
		return cs.addImage(c);
		
	}
}
