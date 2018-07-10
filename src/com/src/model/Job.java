package com.src.model;

public class Job {
	
	
	private int id;
	private String companyName;
	private String role;
	private double expRequired;
	private String salary;
	private String workLocation;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public double getExpRequired() {
		return expRequired;
	}
	public void setExpRequired(double expRequired) {
		this.expRequired = expRequired;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getWorkLocation() {
		return workLocation;
	}
	public void setWorkLocation(String workLocation) {
		this.workLocation = workLocation;
	}
	

}
