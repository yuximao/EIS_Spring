package com.mercury.EconomicalInsuranceSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.EconomicalInsuranceSystem.beans.Claim;
import com.mercury.EconomicalInsuranceSystem.beans.ClaimImage;
import com.mercury.EconomicalInsuranceSystem.daos.ClaimDao;
import com.mercury.EconomicalInsuranceSystem.http.Response;

@Service
public class ClaimService {
	@Autowired
	private ClaimDao cd;

	public List<Claim> getByUser(int id) {
		return cd.findAllByUid(id);
	}
	public List<Claim> getByInsid(int iid) {
		return cd.findAllByInsurid(iid);
	}

	public Response addNew(Claim c) {
		List<ClaimImage> images = c.getClaimImages();
		images.forEach((i)->{
			i.setClaim(c);
		});
		c.setClaimImages(images);
		cd.save(c);
		return new Response(true);
	}

	public List<Claim> getAllCalims() {
		System.out.println("claim service get all");
		return cd.findAll();
	}
}
