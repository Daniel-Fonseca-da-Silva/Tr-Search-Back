package com.dafon.trsearchback.dto;

import jakarta.validation.constraints.*;

public record CreateCorporateUserDto(

        @NotBlank
        String name,

        @NotBlank
        String cellphone,

        @NotBlank
//        @Pattern(regexp = "^(?=.*\\\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$")
        String password,

        @Email
        @NotBlank
        String email,

        String photo,

        @NotBlank
        String documentation,

        String telephone
) {
}
