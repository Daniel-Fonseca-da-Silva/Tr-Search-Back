package com.dafon.trsearchback.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;


public interface BaseCrud<T, V, X> {

    ResponseEntity<T> createObject(T dto, UriComponentsBuilder uriBuilder);

    ResponseEntity<V> updateObject(V dto);

    ResponseEntity<X> findObject(String value);

    ResponseEntity<Void> removeObject(String value);
}
