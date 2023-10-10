package com.dafon.trsearchback.dto;

import com.dafon.trsearchback.model.Gender;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record DatasRegularUserUpdateDto(

        @NotNull
        UUID id,

        String name,

        String cellphone,

//        @Pattern(regexp = "^(?=.*\\\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$")
        String password,

        String email,

        String photo,

        String documentation,

        LocalDate birthday,

        Gender gender
) {
}
