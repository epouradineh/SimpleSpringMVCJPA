package com.adineh.jpatest.entity;

public class Instrument {
	
	private int in_id;
	private String in_name;
	
	public Instrument() {
		
	}

	public Instrument(String in_name) {
		this.in_name = in_name;
	}

	public int getIn_id() {
		return in_id;
	}

	public void setIn_id(int in_id) {
		this.in_id = in_id;
	}

	public String getIn_name() {
		return in_name;
	}

	public void setIn_name(String in_name) {
		this.in_name = in_name;
	}

}
