package com.mercury.EconomicalInsuranceSystem.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.EconomicalInsuranceSystem.beans.Car;
import com.mercury.EconomicalInsuranceSystem.beans.Insurance;
import com.mercury.EconomicalInsuranceSystem.daos.CarDao;
import com.mercury.EconomicalInsuranceSystem.daos.InsuranceDao;
import com.mercury.EconomicalInsuranceSystem.http.Response;

@Service
public class CarService {
	@Autowired
	private CarDao cd;
	
	@Autowired
	private InsuranceDao insuranceDao;

	public Response addCar(Car c) {
		Insurance i = (Insurance)insuranceDao.findById(c.getInsurance().getId()).get();
		
		System.out.println("CarService i: " + i);
		List<Car> newCar = new ArrayList<>();
		newCar = i.getCars();
		newCar.add(c);
		i.setCars(newCar);
	

		c.setInsurance(i);
//		insuranceDao.save(i);
		cd.save(c);
		return new Response(true);
	}

	public Optional<Car> getById(int id) {
		return cd.findById(id);
	}

	public List<Car> getCar() {
		return cd.findAll();
	}

	public List<Car> getByUser(int id) {
		return cd.findAllByUid(id);
	}

	public Response updateByCar(Car car) {
		Car c = (Car) cd.findById(car.getId()).get();
		c.setCarphoto(car.getCarphoto());
		c.setMiles(car.getMiles());
		c.setColor(car.getColor());
		cd.save(c);
		return new Response(true);
	}
}
