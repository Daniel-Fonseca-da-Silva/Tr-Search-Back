package com.dafon.trsearchback.dto;

public record CreateAddressDto(

        String corporate_user_id,

        String regular_user_id,

        String establishment_id,

        String zipCode,

        String number,

        String district,

        String street,

        String city,

        String state) {
}
