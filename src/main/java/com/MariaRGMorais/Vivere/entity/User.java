package com.MariaRGMorais.Vivere.entity;

import java.io.Serializable;

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
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;

	@Column(name = "dateTime", columnDefinition = "DATETIME")
	public String dateTime;

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

	@Enumerated(EnumType.STRING)
	@Column(name = "status", columnDefinition = "enum('A','O')", nullable = false, length = 1)
	private Type status;

	@Enumerated(EnumType.STRING)
	@Column(name = "type", columnDefinition = "enum('A','C')", nullable = false, length = 1)
	private Type type;

	public enum Status {
		A, O;

	}

	public enum Type {
		A, C;

	}
}