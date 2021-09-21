package com.trsearch.trsearch.service;

import com.trsearch.trsearch.model.Establishments;

import java.util.ArrayList;
import java.util.List;

public class EstablishmentService {

    public List<Establishments> getEstablishments() {
        List<Establishments> establishments = new ArrayList<>();

        establishments.add(new Establishments("Padaria", "Três Rios"));
        establishments.add(new Establishments("Mercado", "Levy"));
        establishments.add(new Establishments("Açougue", "Paraiba do Sul"));

        return establishments;
    }

}
