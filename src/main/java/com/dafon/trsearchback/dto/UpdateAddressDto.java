package com.dafon.trsearchback.dto;

import com.dafon.trsearchback.model.Address;

import java.util.UUID;

public record UpdateAddressDto(UUID id, String zipCode, String number, String district, String street, String city, String state) {
public UpdateAddressDto(Address address) {
        this(
                address.getId(),
                address.getZipCode(),
                address.getNumber(),
                address.getDistrict(),
                address.getStreet(),
                address.getCity(),
                address.getState()
        );
    }
}
