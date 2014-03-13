package com.brewduck.web.domain;

import java.io.Serializable;

//import org.hibernate.validator.constraints.NotEmpty;

public class Search implements Serializable {

	private static final long serialVersionUID = 8751282105532159742L;

	//@NotEmpty
	private String userid;
	//@NotEmpty
	private String email;
	//@NotEmpty
	private String name;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
