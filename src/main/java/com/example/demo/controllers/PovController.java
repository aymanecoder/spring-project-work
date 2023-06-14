package com.example.demo.controllers;


import com.example.demo.entities.Pov;
import com.example.demo.services.PovService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/manager")
@PreAuthorize("hasRole('MANGER')")
@CrossOrigin(origins = "http://localhost:4200")
public class PovController {
    private static final Logger logger = Logger.getLogger(String.valueOf(PovController.class));
    private final PovService povService;
    @GetMapping("/povs")
    public List<Pov> getAllPovs() {
        return povService.getAllPovs();
    }

    @GetMapping("pov/{id}")
    public Pov getPovById(@PathVariable Long id) {
        return povService.getPovById(id);
    }

    @PostMapping("pov")
    public Pov createPov(@RequestBody Pov pov) {
        return povService.createPov(pov);
    }

    @PutMapping("pov/{id}")
    public Pov updatePov(@PathVariable Long id, @RequestBody Pov pov) {
        return povService.updatePov(id, pov);
    }

    @DeleteMapping("pov/{id}")
    public void deletePov(@PathVariable Long id) {
        povService.deletePov(id);
    }
}

