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

@Entity
@Table(name = "eis_claim")
public class Claim {

	@Id
	@SequenceGenerator(name = "msi_8ser_sql_gen", sequenceName = "EIS_CLAIM_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "msi_8ser_sql_gen", strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "USER_ID")
	private int uid;

	@Column(name="INSUR_ID")
	private int insurid;

	@Column
	private String ticket;

	@Column
	private Date ticketdate;

	@Column
	private String detail;
	
	@Column
	private String emerphone;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy="claim")
	private List<ClaimImage> claimImages;

	public Claim() {
		super();
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}



	public int getInsurid() {
		return insurid;
	}

	public void setInsurid(int insurid) {
		this.insurid = insurid;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public Date getTicketdate() {
		return ticketdate;
	}

	public void setTicketdate(Date ticketdate) {
		this.ticketdate = ticketdate;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
 
	public List<ClaimImage> getClaimImages() {
		System.out.println("get claim image: " + claimImages);
		return claimImages;
	}

	public void setClaimImages(List<ClaimImage> claimImages) {
		this.claimImages = claimImages;
	}


	public Claim(int id, int uid, int insurid, String ticket, Date ticketdate, String detail, String emerphone,
			List<ClaimImage> claimImages) {
		super();
		this.id = id;
		this.uid = uid;
		this.insurid = insurid;
		this.ticket = ticket;
		this.ticketdate = ticketdate;
		this.detail = detail;
		this.emerphone = emerphone;
		this.claimImages = claimImages;
	}


	public String getEmerphone() {
		return emerphone;
	}


	public void setEmerphone(String emerphone) {
		this.emerphone = emerphone;
	}


	@Override
	public String toString() {
		return "Claim [id=" + id + ", uid=" + uid + ", insurid=" + insurid + ", ticket=" + ticket + ", ticketdate="
				+ ticketdate + ", detail=" + detail + ", emerphone=" + emerphone + ", claimImages=" + claimImages + "]";
	}

	

	
}
