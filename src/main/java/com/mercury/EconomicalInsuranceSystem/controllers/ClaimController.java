package com.mercury.EconomicalInsuranceSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.EconomicalInsuranceSystem.beans.Claim;
import com.mercury.EconomicalInsuranceSystem.http.Response;
import com.mercury.EconomicalInsuranceSystem.services.ClaimService;

@RestController
@RequestMapping("/claim")
public class ClaimController {
	@Autowired
	private ClaimService cs;

	@GetMapping()
	public List<Claim> getClaims(){
		return cs.getAllCalims();
	}
	@GetMapping("/{id}")
	public List<Claim> getbyUser(@PathVariable int id) {
		return cs.getByUser(id);
	}
	@GetMapping("insur/{id}")
	public List<Claim> getbyInsur(@PathVariable int id) {
		return cs.getByInsid(id);
	}

	@PostMapping
	public Response addNewClaim(@RequestBody Claim c) {
		System.out.println("addNewClaim: " + c); 
		return cs.addNew(c);
	}
}
