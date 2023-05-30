package com.example.demo.services;

import com.example.demo.entities.Suivi;

import java.util.List;

public interface SuivieService {
    List<Suivi> getAllSuivis();
    Suivi getSuiviById(Long id);
    Suivi createSuivi(Suivi suivi);
    Suivi updateSuivi(Long id, Suivi suivi);
    void deleteSuivi(Long id);
}
