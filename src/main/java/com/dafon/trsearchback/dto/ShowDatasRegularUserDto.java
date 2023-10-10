package com.dafon.trsearchback.dto;

import com.dafon.trsearchback.model.Gender;
import com.dafon.trsearchback.model.RegularUser;

import java.util.UUID;

public record ShowDatasRegularUserDto(UUID id, String name, String cellphone, String email, Gender gender) {
    public ShowDatasRegularUserDto(RegularUser regularUser) {
        this(regularUser.getId(), regularUser.getName(), regularUser.getCellphone(), regularUser.getEmail(), regularUser.getGender());
    }
}
