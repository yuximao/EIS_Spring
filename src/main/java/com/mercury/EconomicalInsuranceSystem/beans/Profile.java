package com.mercury.EconomicalInsuranceSystem.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="EIS_USER_PROFILE")
public class Profile {
	@Id
	@SequenceGenerator(name = "msi_8ser_sql_gen", sequenceName = "EIS_USER_PROFILE_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "msi_8ser_sql_gen", strategy = GenerationType.AUTO)
	private int id;
	@Column(name="USER_ID")
	private int uid;
	@Column
	private int age;
	@Column
	private String address;
	@Column
	private int driving_age;
	@Column
	private String degree;
	@Column
	private String photo;
	@Column 
	private String selphone;
	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getSelphone() {
		return selphone;
	}

	public void setSelphone(String selphone) {
		this.selphone = selphone;
	}

	@Override
	public String toString() {
		return "Profile [id=" + id + ", uid=" + uid + ", age=" + age + ", address=" + address + ", driving_age="
				+ driving_age + ", degree=" + degree + ", photo=" + photo + ", selphone=" + selphone + "]";
	}

	public Profile(int id, int uid, int age, String address, int driving_age, String degree, String photo, String selphone) {
		super();
		this.id = id;
		this.uid = uid;
		this.age = age;
		this.address = address;
		this.driving_age = driving_age;
		this.degree = degree;
		this.photo = photo;
		this.selphone = selphone;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getDriving_age() {
		return driving_age;
	}
	public void setDriving_age(int driving_age) {
		this.driving_age = driving_age;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	
	
}
