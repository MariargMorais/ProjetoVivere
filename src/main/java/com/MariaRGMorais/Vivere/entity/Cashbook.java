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
@Table(name = "cashbook")
public class Cashbook implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cashbookId")
	private int cashbookId;
	
	@Column(name = "dateTime", columnDefinition = "datetime")
	public String dateTime;

	@Column(name = "description", nullable = false, length = 50)
	private String description;

	@Enumerated(EnumType.STRING)
	@Column(name = "type", columnDefinition = "enum('D','C')", nullable = false, length = 1)
	private Type type;

	@Column(name = "value", nullable = false, columnDefinition = "decimal(12,2)")
	private float value;

	public enum Type {
		D, C;

	}
}