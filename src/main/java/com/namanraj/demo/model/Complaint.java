package com.namanraj.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Complaint 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String roll;
	private String name;
	private String hostel;
	private int room;
	private String ctype;
	private String compbody;
	private String status;
	private String message;
	private String timestamp;
	
	
	public Complaint() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Complaint(int id, String roll, String name, String hostel, int room, String ctype, String compbody,
			String status, String message, String timestamp) {
		super();
		this.id = id;
		this.roll = roll;
		this.name = name;
		this.hostel = hostel;
		this.room = room;
		this.ctype = ctype;
		this.compbody = compbody;
		this.status = status;
		this.message = message;
		this.timestamp = timestamp;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoll() {
		return roll;
	}
	public void setRoll(String roll) {
		this.roll = roll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHostel() {
		return hostel;
	}
	public void setHostel(String hostel) {
		this.hostel = hostel;
	}
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	public String getCompbody() {
		return compbody;
	}
	public void setCompbody(String compbody) {
		this.compbody = compbody;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Complaint [id=" + id + ", roll=" + roll + ", name=" + name + ", hostel=" + hostel + ", room=" + room
				+ ", ctype=" + ctype + ", compbody=" + compbody + ", status=" + status + ", message=" + message
				+ ", timestamp=" + timestamp + "]";
	}
	
	
	
	
	
	
	
	
	

}
