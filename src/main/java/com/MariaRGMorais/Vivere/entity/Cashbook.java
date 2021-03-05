package com.MariaRGMorais.Vivere.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "users")
public class Cashbook {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cashbookId;

	@JoinColumn(name = "id")
	private long clientId;

	@Column(name = "dateTime", columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	public Date dateTime;

	@Column(name = "Description", nullable = false, length = 50)
	private String description;

	@Column(name = "Email", nullable = false)
	private String email;

	@Column(name = "Type", nullable = false)
	@Enumerated(EnumType.STRING)
	private Type type;
	
	@Column(name = "Value", nullable = false, precision = 12, scale = 2)
	private float value;

	public Cashbook() {

	}

	/**
	 * @param cashbookId
	 * @param clientId
	 * @param dateTime
	 * @param description
	 * @param email
	 * @param type
	 * @param value
	 */
	public Cashbook(long cashbookId, long clientId, Date dateTime, String description, String email, Type type,
			float value) {
		super();
		this.cashbookId = cashbookId;
		this.clientId = clientId;
		this.dateTime = dateTime;
		this.description = description;
		this.email = email;
		this.type = type;
		this.value = value;
	}

	public long getCashbookId() {
		return cashbookId;
	}

	public long getClientId() {
		return clientId;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public String getDescription() {
		return description;
	}

	public String getEmail() {
		return email;
	}

	public Type getType() {
		return type;
	}

	public float getValue() {
		return value;
	}

	public void setCashbookId(long cashbookId) {
		this.cashbookId = cashbookId;
	}

	public void setClientId(long string) {
		this.clientId = string;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public enum Type {
		DEBIT, CREDIT;
	
	}

	public void setValue(float value) {
		this.value = value;
	}
}