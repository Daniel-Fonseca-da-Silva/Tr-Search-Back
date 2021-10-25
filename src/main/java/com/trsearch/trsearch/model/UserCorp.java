package com.trsearch.trsearch.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
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

}
