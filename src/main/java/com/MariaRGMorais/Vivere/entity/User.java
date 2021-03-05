package com.MariaRGMorais.Vivere.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;

	@Column(name = "dateTime", columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	public Date dateTime;

	@Column(name = "Name", nullable = false, length = 30)
	private String name;

	@Column(name = "Login", nullable = false, unique = true, length = 15)
	private String login;

	@Column(name = "Email", nullable = false, length = 100)
	private String email;

	@Column(name = "Password", nullable = false, length = 10)
	private String password;

	@Column(name = "Phone", nullable = false, length = 11)
	private String phone;

	@Column(name = "Status", nullable = false)
	@Enumerated(EnumType.STRING)
	private Status status;

	@Column(name = "Type", nullable = false)
	@Enumerated(EnumType.STRING)
	private Type type;

	public User() {

	}

	/**
	 * @param id
	 * @param dateTime
	 * @param name
	 * @param login
	 * @param email
	 * @param password
	 * @param phone
	 * @param status
	 * @param type
	 */
	public User(long id, Date dateTime, String name, String login, String email, String password, String phone,
			Status status, Type type) {
		super();
		this.userId = id;
		this.dateTime = dateTime;
		this.name = name;
		this.login = login;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.status = status;
		this.type = type;
	}

	public long getId() {
		return userId;
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

	public Status getStatus() {
		return status;
	}

	public Type getType() {
		return type;
	}

	public void setId(long id) {
		this.userId = id;
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

	public void setStatus(Status status) {
		this.status = status;
	}

	public enum Status {
		ADMIN, OPERATOR;

	}

	public void setType(Type type) {
		this.type = type;
	}

	public enum Type {
		ACTIVE, CANCELED;

	}
}