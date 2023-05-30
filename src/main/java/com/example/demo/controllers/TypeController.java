package com.example.demo.controllers;


import com.example.demo.entities.Type;
import com.example.demo.repository.TypeRepository;
import com.example.demo.services.TypeService;
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
public class TypeController {
  private final TypeService typeService;

    @GetMapping("/types")
    public List<Type> getAllTypes() {
        log.info("getAllTypes");
        return typeService.getAllTypes();
    }

    @GetMapping("type/{id}")
    public Type getTypeById(@PathVariable Long id) {
        log.info("getTypeById");
        return typeService.getTypeById(id);
    }

    @PostMapping("/type")
    public Type createType(@RequestBody Type type) {
        log.info("createType");
        return typeService.createType(type);
    }

    @PutMapping("type/{id}")
    public Type updateType(@PathVariable Long id, @RequestBody Type type) {
        log.info("Updating type");
        return typeService.updateType(id, type);
    }

    @DeleteMapping("type/{id}")
    public void deleteType(@PathVariable Long id) {
        log.info("Deleting type");
        typeService.deleteType(id);
    }
}
