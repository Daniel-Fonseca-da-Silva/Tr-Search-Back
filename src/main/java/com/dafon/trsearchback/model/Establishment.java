package com.dafon.trsearchback.model;

import com.dafon.trsearchback.dto.CreateEstablishmentDto;
import com.dafon.trsearchback.dto.UpdateEstablishmentDto;

import com.github.f4b6a3.uuid.UuidCreator;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "establishments")
@Entity(name = "Establishment")
@EqualsAndHashCode(of = "id")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Establishment implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false, unique = true, columnDefinition = "uuid")
    private UUID id;

    @NotBlank
    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 255, nullable = true)
    private String photo;

    @NotBlank
    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @NotBlank
    @Column(length = 20, nullable = false)
    private String telephone;

    @NotBlank
    @Column(length = 20, nullable = false)
    private String cellphone;

    @NotBlank
    @Email
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private Category category;

    @Column(nullable = false)
    private String code;

    @Column(length = 2, nullable = false)
    private Boolean status;

    @CreationTimestamp
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime updatedAt;

    @Column(length = 255)
    private String picture1;

    @Column(length = 255)
    private String picture2;

    @Column(length = 255)
    private String picture3;

    @Column(length = 255)
    private String picture4;

    @Column(length = 255)
    private String picture5;

    @Column(length = 255)
    private String picture6;

    @Column(length = 255)
    private String picture7;

    @Column(length = 255)
    private String picture8;

    @Column(length = 255)
    private String picture9;

    @Column(length = 255)
    private String picture10;

    @ManyToOne
    @JoinColumn(name = "corporate_user_id", nullable = false)
    private CorporateUser corporateUser;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    public Establishment(CreateEstablishmentDto dto) {
        this.name = dto.name();
        this.photo = dto.photo();
        this.description = dto.description();
        this.telephone = dto.telephone();
        this.cellphone = dto.cellphone();
        this.email = dto.email();
        this.category = dto.category();
        this.code = UuidCreator.getTimeOrderedEpoch().toString();
        this.status = true;
        this.picture1 = dto.picture1();
        this.picture2 = dto.picture2();
        this.picture3 = dto.picture3();
        this.picture4 = dto.picture4();
        this.picture5 = dto.picture5();
        this.picture6 = dto.picture6();
        this.picture7 = dto.picture7();
        this.picture8 = dto.picture8();
        this.picture9 = dto.picture9();
        this.picture10 = dto.picture10();
    }

    public void desactivate() {
        this.status = false;
    }

    public void updateInformation(UpdateEstablishmentDto dto) {
        if(dto.name() != null)
            this.name = dto.name();

        if(dto.photo() != null)
            this.photo = dto.photo();

        if(dto.description() != null)
            this.description = dto.description();

        if(dto.telephone() != null)
            this.telephone = dto.telephone();

        if(dto.cellphone() != null)
            this.cellphone = dto.cellphone();

        if(dto.email() != null)
            this.email = dto.email();

        if(dto.category() != null)
            this.category = dto.category();

        if(dto.picture1() != null)
            this.picture1 = dto.picture1();

        if(dto.picture2() != null)
            this.picture2 = dto.picture2();

        if(dto.picture3() != null)
            this.picture3 = dto.picture3();

        if(dto.picture4() != null)
            this.picture4 = dto.picture4();

        if(dto.picture5() != null)
            this.picture5 = dto.picture5();

        if(dto.picture6() != null)
            this.picture6 = dto.picture6();

        if(dto.picture7() != null)
            this.picture7 = dto.picture7();

        if(dto.picture8() != null)
            this.picture8 = dto.picture8();

        if(dto.picture9() != null)
            this.picture9 = dto.picture9();

        if(dto.picture10() != null)
            this.picture10 = dto.picture10();
    }
}
