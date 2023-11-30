package com.dafon.trsearchback.dto;

import com.dafon.trsearchback.model.*;

import java.time.*;
import java.util.UUID;

public record ShowRegularUserDto(UUID id, String name, String cellphone, String email, String documentation,
                                     String password, LocalDate birthday, Gender gender, LocalDateTime lastLogin,
                                     LocalDateTime createdAt, LocalDateTime updateAt) {
    public ShowRegularUserDto(RegularUser regularUser) {
        this(regularUser.getId(), regularUser.getName(), regularUser.getCellphone(), regularUser.getEmail(), regularUser.getDocumentation(), regularUser.getPassword(), regularUser.getBirthday(), regularUser.getGender(), regularUser.getLastLogin(), regularUser.getCreatedAt(), regularUser.getUpdatedAt());
    }
}
