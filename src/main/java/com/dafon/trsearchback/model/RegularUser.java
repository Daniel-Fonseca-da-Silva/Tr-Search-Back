package com.dafon.trsearchback.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Table(name = "regular_users")
@Entity(name = "RegularUser")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegularUser extends User {

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDate birthday;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private Gender gender;
}
