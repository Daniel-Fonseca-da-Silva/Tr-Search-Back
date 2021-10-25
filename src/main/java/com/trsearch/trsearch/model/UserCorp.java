package com.trsearch.trsearch.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserCorp implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 40, nullable = false, unique = true)
	private String nameCorp;
	
	@Column(length = 20, nullable = false, columnDefinition = "CHAR(20)", unique = true)
	private String cnpjCorp;
	
	@Column(length = 12, nullable = false, unique = true)
	private String loginCorp;
	
	@Column(length = 100, nullable = false, unique = true)
	private String emailCorp;
	
	@Column(length = 12, nullable = false, unique = true)
	private String passwordCorp;

	@Deprecated
	public UserCorp() {}

	public UserCorp(Long id, String nameCorp, String cnpjCorp, String loginCorp, String emailCorp,
			String passwordCorp) {
		super();
		this.id = id;
		this.nameCorp = nameCorp;
		this.cnpjCorp = cnpjCorp;
		this.loginCorp = loginCorp;
		this.emailCorp = emailCorp;
		this.passwordCorp = passwordCorp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameCorp() {
		return nameCorp;
	}

	public void setNameCorp(String nameCorp) {
		this.nameCorp = nameCorp;
	}

	public String getCnpjCorp() {
		return cnpjCorp;
	}

	public void setCnpjCorp(String cnpjCorp) {
		this.cnpjCorp = cnpjCorp;
	}

	public String getLoginCorp() {
		return loginCorp;
	}

	public void setLoginCorp(String loginCorp) {
		this.loginCorp = loginCorp;
	}

	public String getEmailCorp() {
		return emailCorp;
	}

	public void setEmailCorp(String emailCorp) {
		this.emailCorp = emailCorp;
	}

	public String getPasswordCorp() {
		return passwordCorp;
	}

	public void setPasswordCorp(String passwordCorp) {
		this.passwordCorp = passwordCorp;
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
		UserCorp other = (UserCorp) obj;
		return Objects.equals(id, other.id);
	}
	
}
