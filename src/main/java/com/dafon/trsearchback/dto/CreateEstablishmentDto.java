package com.dafon.trsearchback.dto;

import com.dafon.trsearchback.model.Category;

public record CreateEstablishmentDto(
        String name,

        String photo,

        String description,

        String telephone,

        String cellphone,

        String email,

        Category category,

        String picture1,

        String picture2,

        String picture3,

        String picture4,

        String picture5,

        String picture6,

        String picture7,

        String picture8,

        String picture9,

        String picture10,
        String zipCode,

        String number,

        String district,

        String street,

        String city,

        String state
) {
}
