package com.trsearch.trsearch.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Data
public class UserCom implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 20, nullable = false)
	private String nameCom;

	@Column(length = 20, nullable = false)
	private String surnameCom;

	@Column(nullable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date birthdayCom;

	@Column(length = 15, nullable = false, unique = true, columnDefinition = "CHAR(15)")
	private String cpfCom;

	@Column(length = 2, nullable = false, columnDefinition = "CHAR(2)")
	private String genderCom;

	@Column(length = 12, nullable = false, unique = true)
	private String loginCom;

	@Column(length = 100, nullable = false, unique = true)
	private String emailCom;

	@Column(length = 12, nullable = false, unique = true)
	private String passwordCom;

}
