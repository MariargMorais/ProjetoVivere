package com.MariaRGMorais.Vivere.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "clients")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long clientId;

	@Column(name = "dateTime", columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	public Date dateTime;

	@Column(name = "Name", nullable = false, length = 30)
	private String name;

	@Column(name = "cpfcnpj", nullable = false, length = 14)
	private String cpfcnpj;

	@Column(name = "Adress", nullable = false, length = 50)
	private String adress;

	@Column(name = "City", nullable = false, length = 40)
	private String city;

	@Column(name = "State", nullable = false, length = 2)
	private String state;

	@Column(name = "PostalCode", nullable = false, length = 8)
	private String postalCode;

	@Column(name = "Phone", nullable = false, length = 11)
	private String phone;

	@Column(name = "Email", nullable = false, length = 100)
	private String email;

	public Client() {

	}

	/**
	 * @param id
	 * @param dateTime
	 * @param name
	 * @param cpfcnpj
	 * @param adress
	 * @param city
	 * @param state
	 * @param postalCode
	 * @param phone
	 * @param email
	 */
	public Client(long id, Date dateTime, String name, String cpfcnpj, String adress, String city, String state,
			String postalCode, String phone, String email) {
		super();
		this.clientId = id;
		this.dateTime = dateTime;
		this.name = name;
		this.cpfcnpj = cpfcnpj;
		this.adress = adress;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.phone = phone;
		this.email = email;
	}

	public long getId() {
		return clientId;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public String getName() {
		return name;
	}

	public String getCpfcnpj() {
		return cpfcnpj;
	}

	public String getAdress() {
		return adress;
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

	public void setId(long id) {
		this.clientId = id;
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

	public void setAdress(String adress) {
		this.adress = adress;
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