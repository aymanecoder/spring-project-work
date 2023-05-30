package com.example.demo.services;

import com.example.demo.entities.Apliance;

import java.util.List;

public interface ApplianceService {
    List<Apliance> getAllAppliances();
    Apliance getApplianceById(Long id);
    Apliance createAppliance(Apliance appliance);
    Apliance updateAppliance(Long id, Apliance appliance);
    void deleteAppliance(Long id);
}
