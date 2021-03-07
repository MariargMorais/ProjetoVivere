package com.MariaRGMorais.Vivere.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "clients")
public class Client implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JoinColumn(name = "clientId", referencedColumnName = "codClient")
	private int clientId;
	
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "clientFK", nullable = false)
	private List<Cashbook> cashbook;

	@Column(name = "dateTime", columnDefinition = "DATETIME")
	private String dateTime;

	@Column(name = "name", nullable = false, length = 30)
	private String name;

	@Column(name = "cpfcnpj", nullable = false, length = 14)
	private String cpfcnpj;

	@Column(name = "address", nullable = false, length = 50)
	private String address;

	@Column(name = "city", nullable = false, length = 40)
	private String city;

	@Column(name = "state", nullable = false, length = 2)
	private char state;

	@Column(name = "postalCode", nullable = false, length = 8)
	private char postalCode;

	@Column(name = "phone", nullable = false, length = 11)
	private String phone;

	@Column(name = "email", nullable = false, length = 100)
	private String email;
}