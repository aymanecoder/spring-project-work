package com.example.demo.services;

import com.example.demo.entities.Pov;

import java.util.List;

public interface PovService {

    List<Pov> getAllPovs();
    Pov getPovById(Long id);
    Pov createPov(Pov pov);
    Pov updatePov(Long id, Pov pov);
    void deletePov(Long id);
}
