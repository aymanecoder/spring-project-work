package com.example.demo.controllers;

import com.example.demo.entities.Apliance;
import com.example.demo.services.ApplianceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;



@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/admin")
@PreAuthorize("hasRole('ADMIN')")
public class ApplianceController {
    private final ApplianceService applianceService;
    private final static Logger logger = Logger.getLogger(String.valueOf(ApplianceController.class));
    @GetMapping("/appliances")
    public List<Apliance> getAllAppliances() {
        logger.info("ressources are available");
        return applianceService.getAllAppliances();

    }


    @GetMapping("appliance/{id}")
    public Apliance getApplianceById(@PathVariable Long id) {

        logger.info("ressource are available");
        return applianceService.getApplianceById(id);
    }

    @PostMapping("/appliance")
    @ResponseStatus(HttpStatus.CREATED)
    public Apliance createAppliance(@RequestBody Apliance appliance) {
        logger.info("Appliance created");
        return applianceService.createAppliance(appliance);

    }

    @PutMapping("appliance/{id}")
    public Apliance updateAppliance(@PathVariable Long id, @RequestBody Apliance appliance) {
        logger.info("appliance updated with success");
        return applianceService.updateAppliance(id, appliance);
    }

    @DeleteMapping("appliance/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)

    public void deleteAppliance(@PathVariable Long id) {
       logger.info("appliance deleted");
        applianceService.deleteAppliance(id);
    }


}
