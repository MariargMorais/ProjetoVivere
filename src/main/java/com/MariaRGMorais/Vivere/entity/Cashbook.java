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
public class Cashbook {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "Name")
	private String name;

	@Column(name = "Email")
	private String email;

	@Column(name = "Type")
	@Enumerated(EnumType.STRING)
	private Type type;

	public Cashbook() {

	}

	public Cashbook(String firstName, String email) {
		super();
		this.name = firstName;
		this.email = email;
	}

	public enum Type {
		DEBITO, CREDITO;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return name;
	}

	public void setFirstName(String firstName) {
		this.name = firstName;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Type getType() {
		return type;
	}
}