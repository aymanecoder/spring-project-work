package com.example.demo.services;

import com.example.demo.entities.Type;
import com.example.demo.repository.TypeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TypeServiceImp implements TypeService{
    private final TypeRepository typeRepository;
    @Override
    public List<Type> getAllTypes() {
        return typeRepository.findAll();
    }

    @Override
    public Type getTypeById(Long id) {
        return typeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Type not found with id: " + id));
    }

    @Override
    public Type createType(Type type) {
        return typeRepository.save(type);
    }

    @Override
    public Type updateType(Long id, Type type) {
        Type existingType = getTypeById(id);
        existingType.setLibelle(type.getLibelle());
        existingType.setAppliances(type.getAppliances());
        return typeRepository.save(existingType);
    }

    @Override
    public void deleteType(Long id) {

        typeRepository.deleteById(id);
    }
}
