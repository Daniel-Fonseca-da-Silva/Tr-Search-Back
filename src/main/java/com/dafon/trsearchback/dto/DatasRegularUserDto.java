package com.dafon.trsearchback.dto;

import com.dafon.trsearchback.model.Gender;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record DatasRegularUserDto(

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

        @Past
        @NotNull
        LocalDate birthday,

        @NotNull
        Gender gender
) {
}
