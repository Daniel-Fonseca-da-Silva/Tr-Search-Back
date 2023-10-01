package com.dafon.trsearchback.model;


import lombok.*;
import org.hibernate.annotations.*;

import javax.persistence.*;
import java.io.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@MappedSuperclass
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false, unique = true, columnDefinition = "uuid")
    private UUID id;

    @Column(length = 100, nullable = false)
    private String first_name;

    @Column(length = 100, nullable = false)
    private String last_name;

    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @Column(length = 255, nullable = false)
    private String password;

    @Column(length = 15, nullable = false, unique = true)
    private String documentation;

    @Column(length = 20, nullable = true)
    private String cellphone;

    @Column(length = 2, nullable = false)
    private Boolean status;

    @Column(length = 255, nullable = true)
    private String photo;

    @Column(length = 255, nullable = true)
    private String roles;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime lastLogin;

    @CreationTimestamp
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime updatedAt;

}
