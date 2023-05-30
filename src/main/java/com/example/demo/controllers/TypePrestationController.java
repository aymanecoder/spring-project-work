package com.example.demo.controllers;


import com.example.demo.entities.TypePrestation;
import com.example.demo.services.TypePrestationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/admin")
@PreAuthorize("hasRole('ADMIN')")
public class TypePrestationController {
    private final TypePrestationService typePrestationService;

    @GetMapping("/Tps")
    public List<TypePrestation> getAllTypePrestations() {
        return typePrestationService.getAllTypePrestations();
    }

    @GetMapping("Tp/{id}")
    public TypePrestation getTypePrestationById(@PathVariable Long id) {
        return typePrestationService.getTypePrestationById(id);
    }

    @PostMapping("Tp")
    public TypePrestation createTypePrestation(@RequestBody TypePrestation typePrestation) {
        return typePrestationService.createTypePrestation(typePrestation);
    }

    @PutMapping("Tp/{id}")
    public TypePrestation updateTypePrestation(@PathVariable Long id, @RequestBody TypePrestation typePrestation) {
        return typePrestationService.updateTypePrestation(id, typePrestation);
    }

    @DeleteMapping("Tp/{id}")
    public void deleteTypePrestation(@PathVariable Long id) {
        typePrestationService.deleteTypePrestation(id);
    }
}
