package com.trsearch.trsearch.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.*;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Data
public class UserCorp implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(targetEntity = Establishment.class, mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Establishment> establishment;

	@Column(length = 40, nullable = false, unique = true)
	private String nameCorp;

	@Column(length = 20, nullable = false, columnDefinition = "CHAR(20)", unique = true)
	private String cnpjCorp;

	@Column(length = 12, nullable = false, unique = true)
	private String loginCorp;

	@Column(length = 100, nullable = false, unique = true)
	private String emailCorp;

	@Column(length = 100, nullable = false, unique = true)
	private String passwordCorp;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_roles",
		joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private List<Role> roles;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}

	@Override
	public String getPassword() {
		return passwordCorp;
	}

	@Override
	public String getUsername() {
		return loginCorp;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

//	public static void main(String[] args) {
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		System.out.println(encoder.encode("nTxrKgY$L@"));
//	}

}
