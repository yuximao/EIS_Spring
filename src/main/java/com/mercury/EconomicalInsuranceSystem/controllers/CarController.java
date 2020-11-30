package com.mercury.EconomicalInsuranceSystem.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.EconomicalInsuranceSystem.beans.Car;
import com.mercury.EconomicalInsuranceSystem.http.Response;
import com.mercury.EconomicalInsuranceSystem.services.CarService;

@RestController
@RequestMapping("/car")
public class CarController {
	@Autowired
	private CarService cs;
	
	@GetMapping("/{id}")
	public Optional<Car> getByid(@PathVariable int id){
		return cs.getById(id);
	}
	@PostMapping
	public Response addCar(@RequestBody Car c){
		return cs.addCar(c);
	}
	@GetMapping
	public List<Car> getCar(){
		return cs.getCar();
	}
	@GetMapping("/byuser/{id}")
	public List<Car> getByUser(@PathVariable int id){
		return cs.getByUser(id);
	}
	@PutMapping
	public Response updateCar(@RequestBody Car c){
		System.out.println("in controller: "+c);
		return cs.updateByCar(c);
	}
}
