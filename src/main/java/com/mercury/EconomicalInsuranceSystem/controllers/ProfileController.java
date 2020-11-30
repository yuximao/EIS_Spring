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

import com.mercury.EconomicalInsuranceSystem.beans.Profile;
import com.mercury.EconomicalInsuranceSystem.http.Response;
import com.mercury.EconomicalInsuranceSystem.services.ProfileService;

@RestController
@RequestMapping("/profile")
public class ProfileController {
	@Autowired
	private ProfileService ps;
	@PostMapping
	public Response addProfile(@RequestBody Profile p){
		System.out.println(p);
		return ps.addProfile(p);
	}
	@GetMapping("/{id}")
	public Profile getByUser(@PathVariable int id){
		return ps.getByUser(id);
	}
	
	@PutMapping
	public Response updateProfile(@RequestBody Profile p){
		return ps.updateP(p);
	}
	@GetMapping
	public List<Profile> getAll(){
		return ps.getAll();
	}
}
