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
    @PreAuthorize("hasAuthority('admin:read')")
    public List<TypePrestation> getAllTypePrestations() {
        return typePrestationService.getAllTypePrestations();
    }

    @GetMapping("Tp/{id}")
    @PreAuthorize("hasAuthority('admin:read')")
    public TypePrestation getTypePrestationById(@PathVariable Long id) {
        return typePrestationService.getTypePrestationById(id);
    }

    @PostMapping("Tp")
    @PreAuthorize("hasAuthority('admin:create')")
    public TypePrestation createTypePrestation(@RequestBody TypePrestation typePrestation) {
        return typePrestationService.createTypePrestation(typePrestation);
    }

    @PutMapping("Tp/{id}")
    @PreAuthorize("hasAuthority('admin:update')")
    public TypePrestation updateTypePrestation(@PathVariable Long id, @RequestBody TypePrestation typePrestation) {
        return typePrestationService.updateTypePrestation(id, typePrestation);
    }

    @DeleteMapping("Tp/{id}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public void deleteTypePrestation(@PathVariable Long id) {
        typePrestationService.deleteTypePrestation(id);
    }
}
