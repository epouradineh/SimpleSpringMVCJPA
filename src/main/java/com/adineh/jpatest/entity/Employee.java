package com.adineh.jpatest.entity;

public class Employee {

	private int em_id;
	private String em_name;
	private String em_family;
	private String em_email;
	
	public Employee() {
		
	}

	public Employee(String em_name, String em_family, String em_email) {
		this.em_name = em_name;
		this.em_family = em_family;
		this.em_email = em_email;
	}

	public int getEm_id() {
		return em_id;
	}

	public void setEm_id(int em_id) {
		this.em_id = em_id;
	}

	public String getEm_name() {
		return em_name;
	}

	public void setEm_name(String em_name) {
		this.em_name = em_name;
	}

	public String getEm_family() {
		return em_family;
	}

	public void setEm_family(String em_family) {
		this.em_family = em_family;
	}

	public String getEm_email() {
		return em_email;
	}

	public void setEm_email(String em_email) {
		this.em_email = em_email;
	}
	
	
}
