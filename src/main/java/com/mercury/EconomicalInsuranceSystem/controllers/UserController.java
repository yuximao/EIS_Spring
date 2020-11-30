package com.mercury.EconomicalInsuranceSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.EconomicalInsuranceSystem.beans.User;
import com.mercury.EconomicalInsuranceSystem.http.Response;
import com.mercury.EconomicalInsuranceSystem.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService us;

	// getAll
	@PreAuthorize("hasAnyAuthority('admin','analyst')")
	@GetMapping
	public List<User> getAll() {
		return us.getAll();

	}

	@GetMapping("/{id}")
	public User getById(@PathVariable int id) {
		return us.getById(id);
	}

	// register
	@PostMapping
	public Response addUser(@RequestBody User u) {
		return us.register(u);
	}
	
//	@PreAuthorize("hasAuthority('admin')")
	@PutMapping
	public Response updateUser(@RequestBody User u){
		System.out.println("controller here");
		return us.updateUser(u);
	}
	
	
	@PutMapping("/password")
	public Response changeUser(@RequestBody User user, Authentication authentication) {
		return us.changePassword(user, authentication);
	}
	

	// delete
	@PreAuthorize("hasAuthority('admin')")
	@DeleteMapping("/{id}")
	public Response deleteUser(@PathVariable int id) {
		return us.deleteUser(id);
	}
	
}
