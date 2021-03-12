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
@Table(name = "users")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "dateTime")
	@JsonFormat(pattern = "dd/MM/yyyy")
	public Date dateTime;

	@Column(name = "name", nullable = false, length = 30)
	private String name;

	@Column(name = "login", nullable = false, unique = true, length = 15)
	private String login;

	@Column(name = "email", nullable = false, length = 100)
	private String email;

	@Column(name = "password", nullable = false, length = 10)
	private String password;

	@Column(name = "phone", nullable = false, length = 11)
	private String phone;

	@Column(name = "status", columnDefinition = "enum('A','C')", nullable = false, length = 1)
	private String status;

	@Column(name = "type", columnDefinition = "enum('A','O')", nullable = false, length = 1)
	private String type;

	public int getId() {
		return id;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public String getName() {
		return name;
	}

	public String getLogin() {
		return login;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getPhone() {
		return phone;
	}

	public String getStatus() {
		return status;
	}

	public String getType() {
		return type;
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

	public void setLogin(String login) {
		this.login = login;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setType(String type) {
		this.type = type;
	}

}