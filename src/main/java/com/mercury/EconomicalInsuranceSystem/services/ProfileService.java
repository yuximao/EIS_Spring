package com.mercury.EconomicalInsuranceSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.EconomicalInsuranceSystem.beans.Profile;
import com.mercury.EconomicalInsuranceSystem.daos.ProfileDao;
import com.mercury.EconomicalInsuranceSystem.http.Response;

@Service
public class ProfileService {
	@Autowired
	private ProfileDao pd;
	
	public Response addProfile(Profile p){
		if(p.getPhoto() == null){
			p.setPhoto("https://cdn2.iconfinder.com/data/icons/ios-7-icons/50/user_male2-512.png");
		}
		pd.save(p);
		return new Response(true);
	}
	public Profile getByUser(int id){
		return pd.findAllByUid(id).get(0); 
	}
	
	public List<Profile> getAll(){
		return pd.findAll();
	}
	
	public Response updateP(Profile p){
		Profile pf = (Profile) pd.findById(p.getId()).get();
		pf.setAddress(p.getAddress());
		pf.setDegree(p.getDegree());
		pf.setPhoto(p.getPhoto());
		pf.setAge(p.getAge());
		pf.setDriving_age(p.getDriving_age());
		pf.setSelphone(p.getSelphone());
		pd.save(pf);
		return new Response(true);
	}

}
