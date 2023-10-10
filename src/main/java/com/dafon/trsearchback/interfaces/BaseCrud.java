package com.dafon.trsearchback.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import com.dafon.trsearchback.dto.AllDatasRegularUserDto;
import com.dafon.trsearchback.dto.DatasRegularUserDto;
import com.dafon.trsearchback.dto.ShowDatasRegularUserDto;
import com.dafon.trsearchback.dto.DatasRegularUserUpdateDto;

import java.util.*;

public interface BaseCrud<T> {

    ResponseEntity<DatasRegularUserDto> createObject(DatasRegularUserDto dto, UriComponentsBuilder uriBuilder);

    ResponseEntity<AllDatasRegularUserDto> updateObject(DatasRegularUserUpdateDto dto);

    ResponseEntity<AllDatasRegularUserDto> findObject(UUID id);

    ResponseEntity<Page<ShowDatasRegularUserDto>> findObjects(Pageable pagination);

    ResponseEntity<Void> removeObject(UUID id);
}
