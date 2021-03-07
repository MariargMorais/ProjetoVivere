package com.MariaRGMorais.Vivere.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "clients")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int clientId;

	@Column(name = "dateTime", columnDefinition = "DATETIME")
	public String dateTime;

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
}