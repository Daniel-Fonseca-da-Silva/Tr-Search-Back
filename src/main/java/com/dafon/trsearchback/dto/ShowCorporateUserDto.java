package com.dafon.trsearchback.dto;

import com.dafon.trsearchback.model.CorporateUser;
import com.dafon.trsearchback.model.Premium;

import java.time.LocalDateTime;

public record ShowCorporateUserDto(String name, String cellphone, String email, String documentation, Premium premium, String telephone, LocalDateTime lastLogin, LocalDateTime createdAt, LocalDateTime updateAt) {
    public ShowCorporateUserDto(CorporateUser corporateUser) {
        this(corporateUser.getName(), corporateUser.getCellphone(), corporateUser.getEmail(), corporateUser.getDocumentation(), corporateUser.getPremium(), corporateUser.getTelephone(), corporateUser.getLastLogin(), corporateUser.getCreatedAt(), corporateUser.getUpdatedAt());
    }
}
