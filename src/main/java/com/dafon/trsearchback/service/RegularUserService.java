package com.dafon.trsearchback.service;

import com.dafon.trsearchback.dto.DatasRegularUserUpdateDto;
import com.dafon.trsearchback.dto.ShowDatasRegularUserDto;
import com.dafon.trsearchback.model.RegularUser;
import com.dafon.trsearchback.repository.RegularUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RegularUserService {

    private final RegularUserRepository regularUserRepository;

    @Autowired
    public RegularUserService(RegularUserRepository regularUserRepository) {
        this.regularUserRepository = regularUserRepository;
    }

    public void createElement(RegularUser user) {
        regularUserRepository.save(user);
    }

    public RegularUser updateElement(DatasRegularUserUpdateDto dto) {
        var user = regularUserRepository.getReferenceById(dto.id());
        user.updateInformation(dto);
        return user;
    }

    public RegularUser findElement(UUID id) {
        return regularUserRepository.getReferenceById(id);
    }

    public Page<ShowDatasRegularUserDto> findElements(Pageable pagination) {
        return regularUserRepository.findAll(pagination).map(ShowDatasRegularUserDto::new);
    }

    public void removeElement(UUID id) {
        var user = regularUserRepository.getReferenceById(id);
        user.desactivate();
    }
}
