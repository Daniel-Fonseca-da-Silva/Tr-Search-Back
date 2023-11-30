package com.dafon.trsearchback.model;

import com.dafon.trsearchback.dto.CreateAddressDto;
import com.dafon.trsearchback.dto.UpdateAddressDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "addresses")
@Entity(name = "Address")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Address implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false, unique = true, columnDefinition = "uuid")
    private UUID id;

    @NotBlank
    @Column(length = 30, nullable = false)
    private String zipCode;

    @NotBlank
    @Column(nullable = false)
    private String number;

    @NotBlank
    @Column(length = 100, nullable = false)
    private String district;

    @NotBlank
    @Column(length = 100, nullable = false)
    private String street;

    @NotBlank
    @Column(length = 50, nullable = false)
    private String city;

    @NotBlank
    @Column(length = 2, nullable = false)
    private String state;

    @Column(length = 2, nullable = false)
    private Boolean status;

    @CreationTimestamp
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime updatedAt;

    @OneToOne(mappedBy = "address")
    private RegularUser regularUser;

    @OneToOne(mappedBy = "address")
    private CorporateUser corporateUser;

    @OneToOne(mappedBy = "address")
    private Establishment establishment;

    public Address(CreateAddressDto dto) {
        this.zipCode = dto.zipCode();
        this.number = dto.number();
        this.district = dto.district();
        this.street = dto.street();
        this.city = dto.city();
        this.state = dto.state();
        this.status = true;
    }

    public void updateInformation(UpdateAddressDto dto) {
        if(dto.zipCode() != null) {
            zipCode = dto.zipCode();
        }
        if(dto.number() != null) {
            number = dto.number();
        }
        if(dto.district() != null) {
            district = dto.district();
        }
        if(dto.street() != null) {
            street = dto.street();
        }
        if(dto.city() != null) {
            city = dto.city();
        }
        if(dto.state() != null) {
            state = dto.state();
        }
    }

    public void desactivate() {
        this.status = false;
    }

}
