package com.dafon.trsearchback.dto;

import com.dafon.trsearchback.model.CorporateUser;

public record UpdateCorporateUserDto(String name, String cellphone, String email, String documentation, String telephone, String photo) {

    public UpdateCorporateUserDto(CorporateUser corporateUser) {
        this(
                corporateUser.getName(),
                corporateUser.getCellphone(),
                corporateUser.getEmail(),
                corporateUser.getDocumentation(),
                corporateUser.getTelephone(),
                corporateUser.getPhoto()
        );
    }
}
