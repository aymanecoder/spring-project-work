package com.example.demo.services;


import com.example.demo.entities.TypePrestation;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TypePrestationService {

    List<TypePrestation> getAllTypePrestations();
    TypePrestation getTypePrestationById(Long id);
    TypePrestation createTypePrestation(TypePrestation typePrestation);
    TypePrestation updateTypePrestation(Long id, TypePrestation typePrestation);
    void deleteTypePrestation(Long id);
}
