package com.example.demo.services;


import com.example.demo.entities.Pov;
import com.example.demo.repository.PovRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PovServiceImp implements PovService{
    private final PovRepository povRepository;
    @Override
    public List<Pov> getAllPovs() {
        return povRepository.findAll();
    }

    @Override
    public Pov getPovById(Long id) {
        return povRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Pov not found for id: " + id));
    }

    @Override
    public Pov createPov(Pov pov) {
        return povRepository.save(pov);
    }

    @Override
    public Pov updatePov(Long id, Pov pov) {
        Pov existingPov = getPovById(id);
        existingPov.setDateDebut(pov.getDateDebut());
        existingPov.setDateFin(pov.getDateFin());
        existingPov.setDescription(pov.getDescription());
        existingPov.setCompteManager(pov.getCompteManager());
        existingPov.setIngenieurCybersecurite(pov.getIngenieurCybersecurite());
        existingPov.setAnalystCybersecurite(pov.getAnalystCybersecurite());
        existingPov.setLibellePov(pov.getLibellePov());
        existingPov.setClients(pov.getClients());
        existingPov.setAppliances(pov.getAppliances());
        return povRepository.save(existingPov);
    }

    @Override
    public void deletePov(Long id) {
        Pov existingPov = getPovById(id);
        povRepository.delete(existingPov);
    }
}
