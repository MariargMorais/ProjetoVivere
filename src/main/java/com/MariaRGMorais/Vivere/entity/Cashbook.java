package com.MariaRGMorais.Vivere.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "cashbook")
public class Cashbook {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cashbookId;

	@JoinColumn(name = "clientId", nullable = false)
	private int clientId;

	@Column(name = "dateTime")
	public String dateTime;

	@Column(name = "Description", nullable = false, length = 50)
	private String description;

	@Column(name = "Email", nullable = false)
	private String email;

	@Column(name = "Type", nullable = false)
	@Enumerated(EnumType.STRING)
	private Type type;

	@Column(name = "Value", nullable = false, precision = 12, scale = 2)
	private float value;

	public enum Type {
		D, C;

	}
}