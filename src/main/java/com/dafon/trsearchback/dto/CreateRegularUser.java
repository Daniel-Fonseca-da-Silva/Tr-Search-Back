package com.dafon.trsearchback.dto;

import com.dafon.trsearchback.model.Gender;

import java.time.LocalDate;

public record CreateRegularUser(
        String name,

        String cellphone,

        String password,

        String email,

        String documentation,

        String photo,

        LocalDate birthday,

        Gender gender,

        String zipCode,

        String number,

        String district,

        String street,

        String city,

        String state

) {

}
