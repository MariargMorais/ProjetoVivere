package com.MariaRGMorais.Vivere.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "Name")
	private String name;

	@Column (unique=true, name = "Login")
	private String login;

	@Column(name = "Email")
	private String email;

	@Column(name = "Status")
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Column(name = "Type")
	@Enumerated(EnumType.STRING)
	private Type type;

	public User() {

	}

	public User(String firstName, String email) {
		super();
		this.name = firstName;
		this.email = email;
	}

	public enum Status {
		ADMINISTRADOR, OPERADOR;

	}

	public enum Type {
		ATIVO, CANCELADO;

	}

	public long getId() {
		return id;
	}

	public Status getStatus() {
		return status;
	}

	public Type getType() {
		return type;
	}

	public String getFirstName() {
		return name;
	}

	public String getLastName() {
		return login;
	}

	public String getEmail() {
		return email;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.name = firstName;
	}

	public void setLastName(String lastName) {
		this.login = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setType(Type type) {
		this.type = type;
	}
}