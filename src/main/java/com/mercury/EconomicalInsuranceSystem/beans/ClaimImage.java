package com.mercury.EconomicalInsuranceSystem.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "EIS_CLAIM_IMAGE")
public class ClaimImage {

	@Id
	@SequenceGenerator(name = "msi_8ser_sql_gen", sequenceName = "EIS_CLAIM_IMAGE_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "msi_8ser_sql_gen", strategy = GenerationType.AUTO)
	private int id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CID")
	private Claim claim;

	@Column
	private String url;

	public ClaimImage() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


	public ClaimImage(int id, Claim claim, String url) {
		super();
		this.id = id;
		this.claim = claim;
		this.url = url;
	}


	
	@JsonIgnore
	public Claim getClaim() {
		return claim;
	}


	public void setClaim(Claim claim) {
		this.claim = claim;
	}


	@Override
	public String toString() {
		return "ClaimImage [id=" + id  + ", url=" + url + "]";
	}


}
