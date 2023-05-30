package com.example.demo.services;


import com.example.demo.entities.Apliance;
import com.example.demo.repository.AplianceRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApplianceServiceImp implements  ApplianceService{
    private final AplianceRepository applianceRepository;
    @Override
    public List<Apliance> getAllAppliances() {
        return applianceRepository.findAll();

    }

    @Override
    public Apliance getApplianceById(Long id) {
        return applianceRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Appliance not found for id: " + id));
    }

    @Override
    public Apliance createAppliance(Apliance appliance) {
        return applianceRepository.save(appliance);
    }

    @Override
    public Apliance updateAppliance(Long id, Apliance appliance) {
        Apliance existingAppliance = getApplianceById(id);
        existingAppliance.setLibelle(appliance.getLibelle());
        existingAppliance.setDbid(appliance.getDbid());
        existingAppliance.setDisponibilite(appliance.isDisponibilite());
        existingAppliance.setReference(appliance.getReference());
        existingAppliance.setType(appliance.getType());
        return applianceRepository.save(existingAppliance);
    }

    @Override
    public void deleteAppliance(Long id) {
        Apliance existingAppliance = getApplianceById(id);
        applianceRepository.delete(existingAppliance);
    }
}
