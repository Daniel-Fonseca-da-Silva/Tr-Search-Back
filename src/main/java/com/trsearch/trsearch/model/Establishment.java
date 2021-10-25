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

	@Deprecated
	public Establishment() {}

	public Establishment(Long id, String name, String site, String address, String numberr, String cep, String email,
			String tel, String cel, String district, String city, String state, String category, String imgurl,
			String description, Double score, Boolean actived, Date dataest) {
		super();
		this.id = id;
		this.name = name;
		this.site = site;
		this.address = address;
		this.numberr = numberr;
		this.cep = cep;
		this.email = email;
		this.tel = tel;
		this.cel = cel;
		this.district = district;
		this.city = city;
		this.state = state;
		this.category = category;
		this.imgurl = imgurl;
		this.description = description;
		this.score = score;
		this.actived = actived;
		this.dataest = dataest;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNumberr() {
		return numberr;
	}

	public void setNumberr(String numberr) {
		this.numberr = numberr;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getCel() {
		return cel;
	}

	public void setCel(String cel) {
		this.cel = cel;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Boolean getActive() {
		return actived;
	}

	public void setActive(Boolean active) {
		this.actived = active;
	}

	public Date getDataest() {
		return dataest;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Establishment other = (Establishment) obj;
		return Objects.equals(name, other.name);
	}

}
