package com.MariaRGMorais.Vivere.entity.DTO;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CashbookInsert {

	private int id;

	@JsonFormat(pattern = "dd/MM/yyyy")
	public Date dateTime;

	private String description;

	private String type;

	private Float value;

	private Integer client;

	public CashbookInsert(int cashbookId, Date dateTime, String description, String type, Float value) {
		super();
		this.id = cashbookId;
		this.dateTime = dateTime;
		this.description = description;
		this.type = type;
		this.value = value;
	}

	public int getCashbookId() {
		return id;
	}

	public void setCashbookId(int cashbookId) {
		this.id = cashbookId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

	public Integer getClient() {
		return client;
	}

	public void setClient(Integer client) {
		this.client = client;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public Integer getId() {
		// TODO Auto-generated method stub
		return null;
	}

}