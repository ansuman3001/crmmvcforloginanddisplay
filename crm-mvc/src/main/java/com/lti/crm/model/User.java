package com.lti.crm.model;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class User 
{

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		
		Base64.Encoder encoder = Base64.getEncoder();
		String normalString = password;
		String encodedString = encoder.encodeToString(normalString.getBytes(StandardCharsets.UTF_8));
		this.password = encodedString;
	
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", id=" + id + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Id
	@Column(name="id")
	private Integer id;
	
}
