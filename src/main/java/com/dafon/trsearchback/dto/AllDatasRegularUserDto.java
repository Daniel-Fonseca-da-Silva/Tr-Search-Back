package com.dafon.trsearchback.dto;

import com.dafon.trsearchback.model.Gender;
import com.dafon.trsearchback.model.RegularUser;

import java.time.*;
import java.util.UUID;

public record AllDatasRegularUserDto(UUID id, String name, String cellphone, String email, String documentation, String password, LocalDate birthday, Gender gender, LocalDateTime lastLogin, LocalDateTime createdAt) {
    public AllDatasRegularUserDto(RegularUser regularUser) {
        this(regularUser.getId(), regularUser.getName(), regularUser.getCellphone(), regularUser.getEmail(), regularUser.getDocumentation(), regularUser.getPassword(), regularUser.getBirthday(), regularUser.getGender(), regularUser.getLastLogin(), regularUser.getCreatedAt());
    }
}
