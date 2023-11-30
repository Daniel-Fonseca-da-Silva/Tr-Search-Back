package com.dafon.trsearchback.service;

import com.dafon.trsearchback.dto.UpdateAddressDto;
import com.dafon.trsearchback.exception.Custom404Exception;
import com.dafon.trsearchback.model.Address;
import com.dafon.trsearchback.repository.AddressRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Optional;
import java.util.UUID;

@Service
public class AddressService implements Serializable {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address createElement(Address address) {
        return this.addressRepository.save(address);
    }

    public Address updateElement(UpdateAddressDto dto) {

        Optional<Address> optionalAddress = addressRepository.findById(dto.id());

        if(optionalAddress.isPresent()) {
            var address = optionalAddress.get();
            address.updateInformation(dto);
            return addressRepository.save(address);
        }
        else {
            throw new Custom404Exception("Address not found, please verify!");
        }
    }

    public void removeElement(String id) {
        Optional<Address> optionalAddress = addressRepository.findById(UUID.fromString(id));
        if (optionalAddress.isPresent()) {
            var address = optionalAddress.get();
            address.desactivate();
        } else {
            throw new Custom404Exception("Address not found, please verify!");
        }
    }

    public Address findElement(String id) {
        Optional<Address> optionalAddress = addressRepository.findById(UUID.fromString(id));

        if(optionalAddress.isPresent()) {
            return optionalAddress.get();
        }
        else {
            throw new Custom404Exception("Address not found, please verify!");
        }
    }

    public Address findElementByUser(UUID id) {
        Optional<Address> optionalAddress = addressRepository.findByRegularUserId(id);

        if(optionalAddress.isPresent()) {
            return optionalAddress.get();
        }
        else {
            throw new Custom404Exception("Address not found, please verify!");
        }
    }

    public Address findElementByCorporate(UUID id) {
        Optional<Address> optionalAddress = addressRepository.findByCorporateUserId(id);

        if(optionalAddress.isPresent()) {
            return optionalAddress.get();
        }
        else {
            throw new Custom404Exception("Address not found, please verify!");
        }
    }

    public Address findElementByEstablishment(UUID id) {
        Optional<Address> optionalAddress = addressRepository.findByEstablishmentId(id);

        if(optionalAddress.isPresent()) {
            return optionalAddress.get();
        }
        else {
            throw new Custom404Exception("Address not found, please verify!");
        }
    }
}
