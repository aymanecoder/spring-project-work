package com.example.demo.services;

import com.example.demo.entities.TypePrestation;
import com.example.demo.repository.TypePrestationRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TypePrestationServiceImp implements TypePrestationService{

    private final TypePrestationRepository typePrestationRepository;

    @Override
    public List<TypePrestation> getAllTypePrestations() {
        return typePrestationRepository.findAll();
    }

    @Override
    public TypePrestation getTypePrestationById(Long id) {
        return typePrestationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("TypePrestation not found with id: " + id));
    }

    @Override
    public TypePrestation createTypePrestation(TypePrestation typePrestation) {
        return typePrestationRepository.save(typePrestation);
    }

    @Override
    public TypePrestation updateTypePrestation(Long id, TypePrestation typePrestation) {
        TypePrestation existingTypePrestation = getTypePrestationById(id);
        existingTypePrestation.setLibelle(typePrestation.getLibelle());
        existingTypePrestation.setSuivis(typePrestation.getSuivis());
        return typePrestationRepository.save(existingTypePrestation);
    }

    @Override
    public void deleteTypePrestation(Long id) {
        TypePrestation existingTypePrestation = getTypePrestationById(id);
        typePrestationRepository.delete(existingTypePrestation);
    }
}
