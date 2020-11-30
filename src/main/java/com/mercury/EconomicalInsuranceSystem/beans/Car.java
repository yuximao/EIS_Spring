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
@Table(name = "EIS_CAR")
public class Car {
	@Id
	@SequenceGenerator(name = "msi_8ser_sql_gen", sequenceName = "EIS_CAR_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "msi_8ser_sql_gen", strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String vin;
	@Column(name = "USER_ID")
	private int uid;
	@Column
	private String make;
	@Column
	private String model;
	@Column
	private int miles;
	@Column
	private int year;
	@Column
	private String carphoto;
	@Column
	private String color;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "INSUR_ID")
	private Insurance insurance;

	public Car() {
		super();
	}

	public Car(int id, String vin, int uid, String make, String model, int miles, int year, String carphoto,
			String color, Insurance insurance) {
		super();
		this.id = id;
		this.vin = vin;
		this.uid = uid;
		this.make = make;
		this.model = model;
		this.miles = miles;
		this.year = year;
		this.carphoto = carphoto;
		this.color = color;
		this.insurance = insurance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getMiles() {
		return miles;
	}

	public void setMiles(int miles) {
		this.miles = miles;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getCarphoto() {
		return carphoto;
	}

	public void setCarphoto(String carphoto) {
		this.carphoto = carphoto;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@JsonIgnore
	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}



}
