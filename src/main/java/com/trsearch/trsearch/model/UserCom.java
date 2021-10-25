package com.trsearch.trsearch.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
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

	@Deprecated
	public UserCom() {
		super();
	}

	public UserCom(Long id, String nameCom, String surnameCom, Date birthdayCom, String cpfCom, String genderCom,
			String loginCom, String emailCom, String passwordCom) {
		super();
		this.id = id;
		this.nameCom = nameCom;
		this.surnameCom = surnameCom;
		this.birthdayCom = birthdayCom;
		this.cpfCom = cpfCom;
		this.genderCom = genderCom;
		this.loginCom = loginCom;
		this.emailCom = emailCom;
		this.passwordCom = passwordCom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameCom() {
		return nameCom;
	}

	public void setNameCom(String nameCom) {
		this.nameCom = nameCom;
	}

	public String getSurnameCom() {
		return surnameCom;
	}

	public void setSurnameCom(String surnameCom) {
		this.surnameCom = surnameCom;
	}

	public Date getBirthdayCom() {
		return birthdayCom;
	}

	public void setBirthdayCom(Date birthdayCom) {
		this.birthdayCom = birthdayCom;
	}

	public String getCpfCom() {
		return cpfCom;
	}

	public void setCpfCom(String cpfCom) {
		this.cpfCom = cpfCom;
	}

	public String getGenderCom() {
		return genderCom;
	}

	public void setGenderCom(String genderCom) {
		this.genderCom = genderCom;
	}

	public String getLoginCom() {
		return loginCom;
	}

	public void setLoginCom(String loginCom) {
		this.loginCom = loginCom;
	}

	public String getEmailCom() {
		return emailCom;
	}

	public void setEmailCom(String emailCom) {
		this.emailCom = emailCom;
	}

	public String getPasswordCom() {
		return passwordCom;
	}

	public void setPasswordCom(String passwordCom) {
		this.passwordCom = passwordCom;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserCom other = (UserCom) obj;
		return Objects.equals(id, other.id);
	}

}
