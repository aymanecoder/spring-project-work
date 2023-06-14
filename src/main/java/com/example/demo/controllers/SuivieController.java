package com.example.demo.controllers;

import com.example.demo.entities.Suivi;
import com.example.demo.services.SuivieService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/manager")
@PreAuthorize("hasRole('MANGER')")
@CrossOrigin(origins = "http://localhost:4200")
public class SuivieController {
    private final SuivieService suivieService;

    @GetMapping("/suivies")
    public List<Suivi> getAllSuivis() {
        log.info("getAllSuivis");
        return suivieService.getAllSuivis();
    }

    @GetMapping("suivie/{id}")
    public Suivi getSuiviById(@PathVariable Long id) {
        log.info("getSuiviById");
        return suivieService.getSuiviById(id);
    }

    @PostMapping("/suivie")
    public Suivi createSuivi(@RequestBody Suivi suivi) {
        log.info("createSuivi");
        return suivieService.createSuivi(suivi);
    }

    @PutMapping("suivie/{id}")
    public Suivi updateSuivi(@PathVariable Long id, @RequestBody Suivi suivi) {
        log.info("Updating Suivi");
        return suivieService.updateSuivi(id, suivi);
    }

    @DeleteMapping("suivie/{id}")
    public void deleteSuivi(@PathVariable Long id) {
        log.info("deleteSuivi");
        suivieService.deleteSuivi(id);
    }
}
