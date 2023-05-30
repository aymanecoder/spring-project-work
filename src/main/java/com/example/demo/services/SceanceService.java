package com.example.demo.services;

import com.example.demo.entities.Sceance;

import java.util.List;

public interface SceanceService {
    List<Sceance> getAllSceances();
    Sceance getSceanceById(Long id);
    Sceance createSceance(Sceance sceance);
    Sceance updateSceance(Long id, Sceance sceance);
    void deleteSceance(Long id);
}
