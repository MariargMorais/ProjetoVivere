package com.MariaRGMorais.Vivere.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "clients")
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "dateTime")
	@JsonFormat(pattern = "dd/MM/yyyy hh:mm")
	private Date dateTime;

	@Column(name = "name", nullable = false, length = 30)
	private String name;

	@Column(name = "cpfcnpj", nullable = false, length = 14)
	private String cpfcnpj;

	@Column(name = "address", nullable = false, length = 50)
	private String address;

	@Column(name = "city", nullable = false, length = 40)
	private String city;

	@Column(name = "state", nullable = false, length = 2)
	private String state;

	@Column(name = "postalCode", nullable = false, length = 8)
	private String postalCode;

	@Column(name = "phone", nullable = false, length = 11)
	private String phone;

	@Column(name = "email", nullable = false, length = 100)
	private String email;

	public Date getDateTime() {
		return dateTime;
	}

	public String getName() {
		return name;
	}

	public String getCpfcnpj() {
		return cpfcnpj;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCpfcnpj(String cpfcnpj) {
		this.cpfcnpj = cpfcnpj;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}