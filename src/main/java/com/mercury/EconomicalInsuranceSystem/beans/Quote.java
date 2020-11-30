package com.mercury.EconomicalInsuranceSystem.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EIS_QUOTE")
public class Quote {
	@Id
	private int id;
	@Column(name="USER_ID")
	private int uid;
	@Column
	private int price;
	public Quote() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "Quote [id=" + id + ", uid=" + uid + ", price=" + price + "]";
	}

	public Quote(int id, int uid, int price) {
		super();
		this.id = id;
		this.uid = uid;
		this.price = price;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
