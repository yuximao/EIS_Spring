package com.mercury.EconomicalInsuranceSystem.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="EIS_HISTORY")
public class History {
	@Id
	@SequenceGenerator(name = "msi_8ser_sql_gen", sequenceName = "EIS_HISTORY_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "msi_8ser_sql_gen", strategy = GenerationType.AUTO)
	private int id;
	@Column(name="USER_ID")
	private int uid;

	@Column
	private String ticket;
	@Column
	private Date ticketdate;
	public History() {
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
		return "History [id=" + id + ", uid=" + uid + ", ticket=" + ticket + ", ticketdate="
				+ ticketdate + "]";
	}

	public History(int id, int uid, int claim_id, String ticket, Date ticketdate) {
		super();
		this.id = id;
		this.uid = uid;
		this.ticket = ticket;
		this.ticketdate = ticketdate;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
}
