package com.dafon.trsearchback.dto;

import com.dafon.trsearchback.model.Gender;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record CreateRegularUserDto(
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

        @NotBlank
        String documentation,

        String photo,

        @NotNull
        LocalDate birthday,

        @NotNull
        @Enumerated
        Gender gender

) {

}
