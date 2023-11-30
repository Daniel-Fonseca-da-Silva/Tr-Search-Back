package com.dafon.trsearchback.dto;

public record CreateCorporateUserDto(

        String name,

        String cellphone,

        String password,

        String email,

        String photo,

        String documentation,

        String telephone,

        String zipCode,

        String number,

        String district,

        String street,

        String city,

        String state
) {
}
