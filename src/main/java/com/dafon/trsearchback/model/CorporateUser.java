package com.dafon.trsearchback.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "corporate_users")
@Entity(name = "CorporateUse")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CorporateUser extends User {

    @Column(length = 15, nullable = true)
    private String telephone;
    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private Premium premium;

}
