package com.lti.crm.model;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer 
{
@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="custid_generator")
@SequenceGenerator(name="custid_generator", sequenceName="customer_id", allocationSize=1)
@Column(name="id", updatable=false, nullable=false)
private int id;

@Column(name="firstname")
private String firstName;

@Column(name="password")
private String password;

@Column(name="email")
private String email;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) 
{
	
	Base64.Encoder encoder = Base64.getEncoder();
	String normalString = password;
	String encodedString = encoder.encodeToString(normalString.getBytes(StandardCharsets.UTF_8));
	this.password = encodedString;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}
@Override
public String toString() {
	return "Customer [id=" + id + ", firstName=" + firstName + ", password=" + password + ", email=" + email + "]";
}
}