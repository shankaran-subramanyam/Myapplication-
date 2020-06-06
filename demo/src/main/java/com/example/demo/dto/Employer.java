package com.example.demo.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Employer")
public class Employer {
	
	@Id
	private int id;
	private int serialNo;
	private String fName;
	private String lName;
	private boolean status;
	
	
	
	public Employer(int id, int serialNo, String fName, String lName, boolean status) {
		super();
		this.id = id;
		this.serialNo = serialNo;
		this.fName = fName;
		this.lName = lName;
		this.status = status;
	}
	public Employer() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employer other = (Employer) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Single [id=" + id + ", serialNo=" + serialNo + ", fName=" + fName + ", lName=" + lName + ", status="
				+ status + "]";
	}
	
	
	

}
