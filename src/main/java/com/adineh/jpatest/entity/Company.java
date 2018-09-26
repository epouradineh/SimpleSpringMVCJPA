package com.adineh.jpatest.entity;

public class Company {
	
	private int co_id;
	private String co_name;
	private String co_email;
	private String co_address;
	
	public Company() {
		
	}

	public Company(String co_name, String co_email, String co_address) {
		this.co_name = co_name;
		this.co_email = co_email;
		this.co_address = co_address;
	}

	public int getCo_id() {
		return co_id;
	}

	public void setCo_id(int co_id) {
		this.co_id = co_id;
	}

	public String getCo_name() {
		return co_name;
	}

	public void setCo_name(String co_name) {
		this.co_name = co_name;
	}

	public String getCo_email() {
		return co_email;
	}

	public void setCo_email(String co_email) {
		this.co_email = co_email;
	}

	public String getCo_address() {
		return co_address;
	}

	public void setCo_address(String co_address) {
		this.co_address = co_address;
	}

	
}
