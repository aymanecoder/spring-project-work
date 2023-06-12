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
@CrossOrigin(origins = "http://localhost:4200")
public class TypeController {
  private final TypeService typeService;

    @GetMapping("/types")
    @PreAuthorize("hasAuthority('admin:read')")
    public List<Type> getAllTypes() {
        log.info("getAllTypes");
        return typeService.getAllTypes();
    }

    @GetMapping("type/{id}")
    @PreAuthorize("hasAuthority('admin:read')")
    public Type getTypeById(@PathVariable Long id) {
        log.info("getTypeById");
        return typeService.getTypeById(id);
    }

    @PostMapping("/type")
    @PreAuthorize("hasAuthority('admin:create')")
    public Type createType(@RequestBody Type type) {
        log.info("createType");
        return typeService.createType(type);
    }

    @PutMapping("type/{id}")
    @PreAuthorize("hasAuthority('admin:update')")
    public Type updateType(@PathVariable Long id, @RequestBody Type type) {
        log.info("Updating type");
        return typeService.updateType(id, type);
    }

    @DeleteMapping("type/{id}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public void deleteType(@PathVariable Long id) {
        log.info("Deleting type");
        typeService.deleteType(id);
    }
}
