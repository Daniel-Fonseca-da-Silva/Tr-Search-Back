package com.dafon.trsearchback.dto;

import com.dafon.trsearchback.model.Category;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

public record CreateEstablishmentDto(
        @NotBlank
        @Column(length = 100, nullable = false)
        String name,

        @Column(length = 255, nullable = true)
        String photo,

        @NotBlank
        @Column(columnDefinition = "TEXT", nullable = false)
        String description,

        @NotBlank
        @Column(length = 20, nullable = false)
        String telephone,

        @NotBlank
        @Column(length = 20, nullable = false)
        String cellphone,

        @NotBlank
        @Email
        String email,

        @Enumerated(EnumType.STRING)
        @Column(length = 20, nullable = false)
        Category category,

        @Column(length = 255)
        String picture1,

        @Column(length = 255)
        String picture2,

        @Column(length = 255)
        String picture3,

        @Column(length = 255)
        String picture4,

        @Column(length = 255)
        String picture5,

        @Column(length = 255)
        String picture6,

        @Column(length = 255)
        String picture7,

        @Column(length = 255)
        String picture8,

        @Column(length = 255)
        String picture9,

        @Column(length = 255)
        String picture10
) {
}
