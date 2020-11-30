package com.mercury.EconomicalInsuranceSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.EconomicalInsuranceSystem.beans.Insurance;
import com.mercury.EconomicalInsuranceSystem.http.Response;
import com.mercury.EconomicalInsuranceSystem.services.InsuranceService;

@RestController
@RequestMapping("/insurance")
public class InsuranceController {
	@Autowired
	private InsuranceService is;
	
	@PostMapping
	public Response addInsurance(@RequestBody Insurance i){
		System.out.println(i);
		return is.addInsurance(i);
	}
	
	@GetMapping("/{id}")
	public List<Insurance> getbyuser(@PathVariable int id){
		return is.getByUser(id);
	}
	@PutMapping
	public Response updateInsurance (@RequestBody Insurance i){
		return is.putInsurnce(i);
	}
	
	@GetMapping
	public List<Insurance> getAll(){
		return is.getAll();
	}
	
}
