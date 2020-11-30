package com.mercury.EconomicalInsuranceSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.EconomicalInsuranceSystem.beans.Car;
import com.mercury.EconomicalInsuranceSystem.beans.Insurance;
import com.mercury.EconomicalInsuranceSystem.daos.InsuranceDao;
import com.mercury.EconomicalInsuranceSystem.http.Response;

@Service
public class InsuranceService {
	@Autowired
	private InsuranceDao id;
	
	public Response addInsurance(Insurance i){
		List<Car> cars = i.getCars();
		cars.forEach((c)->{
			c.setInsurance(i);
			if (c.getCarphoto() == null){
				c.setCarphoto("https://www.303products.com.au/images/CarIconv2.png");
			}
		});
		i.setCars(cars);
		System.out.println(i);
		id.save(i);
		return new Response(true);
	}
	public List<Insurance> getByUser(int uid){
		return id.findAllByUid(uid);
	}
	
	public Response putInsurnce(Insurance i){
		i.getCars().forEach(c->{
			c.setInsurance(i);
			if (c.getCarphoto() == null){
				c.setCarphoto("https://www.303products.com.au/images/CarIconv2.png");
			}
		});
		id.save(i);

		return new Response(true);

	}
	public List<Insurance> getAll(){
		return id.findAll();
	}
}
