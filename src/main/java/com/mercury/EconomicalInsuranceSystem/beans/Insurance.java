package com.mercury.EconomicalInsuranceSystem.beans;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "EIS_INSURANCE")
public class Insurance {
	@Id
	@SequenceGenerator(name = "msi_8ser_sql_gen", sequenceName = "EIS_INSURANCE_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "msi_8ser_sql_gen", strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "USER_ID")
	private int uid;
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date start_date;
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date end_date;
	@Column
	private int price;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "insurance")
	private List<Car> cars;

	public Insurance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	
	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}



	public Insurance(int id, int uid, Date start_date, Date end_date, int price, List<Car> cars) {
		super();
		this.id = id;
		this.uid = uid;
		this.start_date = start_date;
		this.end_date = end_date;
		this.price = price;
		this.cars = cars;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
