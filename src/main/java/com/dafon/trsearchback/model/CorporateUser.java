package com.dafon.trsearchback.model;

import com.dafon.trsearchback.dto.UpdateCorporateUserDto;
import com.dafon.trsearchback.dto.CreateCorporateUserDto;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.*;

@Table(name = "corporate_users")
@Entity(name = "CorporateUse")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CorporateUser extends User implements UserDetails, Serializable {

    @Column(length = 15, nullable = true)
    private String telephone;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private Premium premium;

    @OneToMany(mappedBy = "corporateUser")
    private Set<Establishment> establishments;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;


    public CorporateUser(CreateCorporateUserDto dto) {
        super.setName(dto.name());
        super.setCellphone(dto.cellphone());
        super.setPassword(dto.password());
        super.setEmail(dto.email());
        super.setPhoto(dto.photo());
        super.setDocumentation(dto.documentation());
        super.setStatus(true);
        super.setRoles("ROLE_CORPORATE");
        this.telephone = dto.telephone();
        this.premium = Premium.FREE;
    }

    public void updateInformation(UpdateCorporateUserDto dto) {
        if(dto.name() != null)
            this.setName(dto.name());

        if(dto.email() != null)
            this.setEmail(dto.email());

        if(dto.photo() != null)
            this.setPhoto(dto.photo());

        if(dto.cellphone() != null)
            this.setCellphone(dto.cellphone());

        if(dto.documentation() != null)
            this.setDocumentation(dto.documentation());

        if(dto.telephone() != null)
            telephone = dto.telephone();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_CORPORATE"));
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getEmail();
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

}
