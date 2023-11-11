package com.dafon.trsearchback.dto;

import com.dafon.trsearchback.model.Gender;
import com.dafon.trsearchback.model.RegularUser;

import java.time.LocalDate;

public record UpdateRegularUserDto(
        String name,

        String cellphone,

        String email,

        String photo,

        String documentation,

        LocalDate birthday,

        Gender gender

) {
        public UpdateRegularUserDto(RegularUser regularUser) {
                this(
                        regularUser.getName(),
                        regularUser.getCellphone(),
                        regularUser.getEmail(),
                        regularUser.getPhoto(),
                        regularUser.getDocumentation(),
                        regularUser.getBirthday(),
                        regularUser.getGender()
                );
        }
}
