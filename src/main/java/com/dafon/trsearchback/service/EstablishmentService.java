package com.dafon.trsearchback.service;

import com.dafon.trsearchback.dto.*;
import com.dafon.trsearchback.model.*;
import com.dafon.trsearchback.repository.EstablishmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EstablishmentService {

    private final EstablishmentRepository establishmentRepository;

    @Autowired
    public EstablishmentService(EstablishmentRepository establishmentRepository) {
        this.establishmentRepository = establishmentRepository;
    }

    public void createElement(Establishment establishment) {
        this.establishmentRepository.save(establishment);
    }

    public Establishment updateElement(UpdateEstablishmentDto dto) {
        var establishment = establishmentRepository.findByCode(dto.code());
        establishment.updateInformation(dto);
        return establishment;
    }

    public Page<ShowDatasEstablishmentDto> findElements(Pageable pagination) {
        return establishmentRepository.findAll(pagination).map(ShowDatasEstablishmentDto::new);
    }

    public Establishment findElementByCategory(Category category) {
        return establishmentRepository.findByCategory(category);
    }

    public Establishment findElement(String name) {
        return establishmentRepository.findElementByName(name);
    }

    public Establishment findElementByCode(String code) {
        return establishmentRepository.findByCode(code);
    }

    public List<Establishment> findElementsEstablishment(UUID corporateUserId) {
        return establishmentRepository.findElementsByCorporateUser(corporateUserId);
    }

    public void removeElement(String code) {
        establishmentRepository.findByCode(code).desactivate();
    }
}
