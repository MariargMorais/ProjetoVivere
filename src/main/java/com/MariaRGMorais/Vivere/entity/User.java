package com.MariaRGMorais.Vivere.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;

	@Column(name = "dateTime")
	public String dateTime;

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

	public enum Status {
		A, O;

	}

	public enum Type {
		A, C;

	}
}