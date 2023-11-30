package com.dafon.trsearchback.dto;

import com.dafon.trsearchback.model.Address;

public record ShowDatasAddressDto(
        String zipCode,

        String number,

        String district,

        String street,

        String city,

        String state
) {
    public ShowDatasAddressDto(Address address) {
        this(
                address.getZipCode(),
                address.getNumber(),
                address.getDistrict(),
                address.getStreet(),
                address.getCity(),
                address.getState()
        );
    }
}
