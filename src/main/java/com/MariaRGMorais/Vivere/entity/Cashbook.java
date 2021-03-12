package com.MariaRGMorais.Vivere.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cashbook")
public class Cashbook implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	public int getId() {
		return id;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public String getDescription() {
		return description;
	}

	public String getType() {
		return type;
	}

	public float getValue() {
		return value;
	}

	public Client getClient() {
		return client;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Column(name = "dateTime")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dateTime;

	@Column(name = "description", nullable = false, length = 50)
	private String description;

	@Column(name = "type", columnDefinition = "enum('D','C')", nullable = false, length = 1)
	private String type;

	@Column(name = "value", nullable = false, columnDefinition = "decimal(12,2)")
	private float value;

	@ManyToOne
	@JsonIgnore
	private Client client;

	public Cashbook() {

	}

	public Cashbook(Integer id, Date dateTime, String description, String type, float value, Client client) {
		this.id = id;
		this.dateTime = dateTime;
		this.description = description;
		this.type = type;
		this.value = value;
		this.client = client;
	}

	public Cashbook(Date dateTime, String description, String type, float value, Client client) {
		super();
		this.dateTime = dateTime;
		this.description = description;
		this.type = type;
		this.value = value;
		this.client = client;
	}

}
