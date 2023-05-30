package com.example.demo.services;

import com.example.demo.entities.Type;

import java.util.List;

public interface TypeService {
    List<Type> getAllTypes();
    Type getTypeById(Long id);
    Type createType(Type type);
    Type updateType(Long id, Type type);
    void deleteType(Long id);
}
