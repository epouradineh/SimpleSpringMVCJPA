package com.adineh.jpatest.entity;

public class Business_responsible {
	
	private int br_table_pk;
	private int br_id;
	private String br_name;
	private String br_email;
	
	public Business_responsible() {
		
	}

	public Business_responsible(int br_id, String br_name, String br_email) {
		this.br_id = br_id;
		this.br_name = br_name;
		this.br_email = br_email;
	}

	public int getBr_table_pk() {
		return br_table_pk;
	}

	public void setBr_table_pk(int br_table_pk) {
		this.br_table_pk = br_table_pk;
	}

	public int getBr_id() {
		return br_id;
	}

	public void setBr_id(int br_id) {
		this.br_id = br_id;
	}

	public String getBr_name() {
		return br_name;
	}

	public void setBr_name(String br_name) {
		this.br_name = br_name;
	}

	public String getBr_email() {
		return br_email;
	}

	public void setBr_email(String br_email) {
		this.br_email = br_email;
	}

	
}
