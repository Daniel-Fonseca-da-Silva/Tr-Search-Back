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
public class Establishment implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 40, nullable = false, unique = true)
	private String name;

	@Column(length = 60)
	private String site;

	@Column(length = 60, nullable = false)
	private String address;

	@Column(length = 10, nullable = false)
	private String numberr;

	@Column(length = 10, nullable = false)
	private String cep;

	@Column(length = 100)
	private String email;

	@Column(length = 15)
	private String tel;

	@Column(length = 15)
	private String cel;

	@Column(length = 50, nullable = false)
	private String district;

	@Column(length = 50, nullable = false)
	private String city;

	@Column(length = 2, nullable = false, columnDefinition = "CHAR(2)")
	private String state;

	@Column(length = 50, nullable = false)
	private String category;

	@Column(length = 255, nullable = false)
	private String imgurl;

	@Column(length = 300, columnDefinition = "TEXT", nullable = false)
	private String description;

	private Double score = 0.0;

	private Boolean actived = false;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataest = new Date();

}
