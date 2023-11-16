package com.dafon.trsearchback.dto;

import com.dafon.trsearchback.model.Category;
import com.dafon.trsearchback.model.Establishment;

public record UpdateEstablishmentDto(
        String name,

        String telephone,

        String photo,

        String cellphone,

        String email,

        Category category,

        String description,

        String code,

        String picture1,

        String picture2,

        String picture3,

        String picture4,

        String picture5,

        String picture6,

        String picture7,

        String picture8,

        String picture9,

        String picture10
) {

    public UpdateEstablishmentDto(Establishment establishment) {
        this(establishment.getName(),
                establishment.getTelephone(),
                establishment.getPhoto(),
                establishment.getCellphone(),
                establishment.getEmail(),
                establishment.getCategory(),
                establishment.getDescription(),
                establishment.getCode(),
                establishment.getPicture1(),
                establishment.getPicture2(),
                establishment.getPicture3(),
                establishment.getPicture4(),
                establishment.getPicture5(),
                establishment.getPicture6(),
                establishment.getPicture7(),
                establishment.getPicture8(),
                establishment.getPicture9(),
                establishment.getPicture10());
    }
}
