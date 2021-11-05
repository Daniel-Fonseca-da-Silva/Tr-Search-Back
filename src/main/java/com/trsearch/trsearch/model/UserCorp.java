package com.trsearch.trsearch.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import lombok.Data;
import org.hibernate.annotations.Cascade;

@Entity
@Data
public class UserCorp implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(targetEntity = Establishment.class, mappedBy = "id", cascade = CascadeType.ALL)
	private List<Establishment> establishment;

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
