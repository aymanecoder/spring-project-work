package com.example.demo.services;

import com.example.demo.entities.Sceance;
import com.example.demo.repository.SceanceRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SceanceServiceImp implements SceanceService{
    private final SceanceRepository sceanceRepository;
    @Override
    public List<Sceance> getAllSceances() {
        return sceanceRepository.findAll();
    }

    @Override
    public Sceance getSceanceById(Long id) {
        return sceanceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Sceance not found with id: " + id));
    }

    @Override
    public Sceance createSceance(Sceance sceance) {
        return sceanceRepository.save(sceance);
    }

    @Override
    public Sceance updateSceance(Long id, Sceance sceance) {
        Sceance existingSceance = getSceanceById(id);
        existingSceance.setDateSceance(sceance.getDateSceance());
        existingSceance.setResumer(sceance.getResumer());
        existingSceance.setParticipants(sceance.getParticipants());
        existingSceance.setPov(sceance.getPov());
        return sceanceRepository.save(existingSceance);
    }

    @Override
    public void deleteSceance(Long id) {
        Sceance existingSceance = getSceanceById(id);
        sceanceRepository.delete(existingSceance);
    }
}
