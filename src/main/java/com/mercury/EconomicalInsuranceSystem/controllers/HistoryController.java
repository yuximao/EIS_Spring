package com.mercury.EconomicalInsuranceSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.EconomicalInsuranceSystem.beans.History;
import com.mercury.EconomicalInsuranceSystem.http.Response;
import com.mercury.EconomicalInsuranceSystem.services.HistoryService;

@RestController
@RequestMapping("/history")
public class HistoryController {
	@Autowired
	private HistoryService hs;
	
	@PostMapping
	public Response addHistory(@RequestBody History h){
		return hs.addHistory(h);
	}
	
	@GetMapping("/{id}")
	public List<History> getByUser(@PathVariable int id){
		return hs.getbyUser(id);
	}
}
