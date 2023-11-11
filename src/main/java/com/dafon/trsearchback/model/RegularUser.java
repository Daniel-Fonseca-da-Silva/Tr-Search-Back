package com.dafon.trsearchback.model;

import com.dafon.trsearchback.dto.CreateRegularUserDto;
import com.dafon.trsearchback.dto.UpdateRegularUserDto;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.time.*;
import java.util.*;

@Table(name = "regular_users")
@Entity(name = "RegularUser")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegularUser extends User implements UserDetails, Serializable {

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDate birthday;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private Gender gender;

    public RegularUser(CreateRegularUserDto dto) {
        super.setName(dto.name());
        super.setCellphone(dto.cellphone());
        super.setPassword(dto.password());
        super.setEmail(dto.email());
        super.setPhoto(dto.photo());
        super.setDocumentation(dto.documentation());
        super.setStatus(true);
        super.setCreatedAt(LocalDateTime.now());
        super.setRoles("ROLE_USER");
        this.birthday = dto.birthday();
        this.gender = dto.gender();
    }

    public void updateInformation(UpdateRegularUserDto dto) {
        if (dto.name() != null)
            this.setName(dto.name());

        if (dto.email() != null)
            this.setEmail(dto.email());

        if (dto.cellphone() != null)
            this.setCellphone(dto.cellphone());

        if (dto.photo() != null)
            this.setPhoto(dto.photo());

        if (dto.birthday() != null)
            this.birthday = dto.birthday();

        if (dto.documentation() != null)
            this.setDocumentation(dto.documentation());

        if (dto.gender() != null)
            gender = dto.gender();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
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
