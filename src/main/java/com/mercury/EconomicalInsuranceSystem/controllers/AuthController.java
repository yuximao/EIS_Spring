package com.mercury.EconomicalInsuranceSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.EconomicalInsuranceSystem.http.Response;
import com.mercury.EconomicalInsuranceSystem.services.AuthService;

@RestController

public class AuthController {
	@Autowired
	private AuthService authService;
	
	@GetMapping("/checklogin")
	public Response checklogin(Authentication authentication) {
		return authService.checklogin(authentication);
	}
}
