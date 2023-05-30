package com.example.demo.controllers;

import com.example.demo.entities.Sceance;
import com.example.demo.services.SceanceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/management")
@PreAuthorize("hasRole('MANGER')")
public class SceanceController {

    private final SceanceService sceanceService;
    @GetMapping("/sceances")
    public List<Sceance> getAllSceances() {
        log.info("getAllSceance");
        return sceanceService.getAllSceances();
    }

    @GetMapping("sceance/{id}")
    public Sceance getSceanceById(@PathVariable Long id) {
        log.info("getSceanceById");
        return sceanceService.getSceanceById(id);
    }

    @PostMapping("sceance")
    public Sceance createSceance(@RequestBody Sceance sceance) {
        return sceanceService.createSceance(sceance);
    }

    @PutMapping("sceance/{id}")
    public Sceance updateSceance(@PathVariable Long id, @RequestBody Sceance sceance) {
        return sceanceService.updateSceance(id, sceance);
    }

    @DeleteMapping("sceance/{id}")
    public void deleteSceance(@PathVariable Long id) {
        sceanceService.deleteSceance(id);
    }
}
