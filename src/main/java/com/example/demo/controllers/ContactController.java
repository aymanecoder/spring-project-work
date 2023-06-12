package com.example.demo.controllers;


import com.example.demo.entities.Contact;
import com.example.demo.services.ContactService;
import jakarta.persistence.Entity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin")
@PreAuthorize("hasRole('ADMIN')")
@CrossOrigin(origins = "http://localhost:4200")
public class ContactController {

    private static final Logger loger = Logger.getLogger(String.valueOf(ContactController.class));
    private final ContactService contactService;
    @GetMapping("/contacts")
    @PreAuthorize("hasAuthority('admin:read')")
    public List<Contact> getContacts() {
        loger.info("getContacts");
        return contactService.getAllcontacts();
    }
    @GetMapping("/contact/{id}")
    @PreAuthorize("hasAuthority('admin:read')")
    public ResponseEntity<Contact> getContactById(@PathVariable Long id){
        loger.info("getContactById");
       return ResponseEntity.ok(contactService.getContactById(id));
    }

    @PostMapping("/contact")
    @PreAuthorize("hasAuthority('admin:create')")
    public ResponseEntity<Contact> addContact(@RequestBody Contact contact){
        loger.info("addContact");
        Contact addContact = contactService.addContact(contact);
        return new ResponseEntity<>(addContact, HttpStatus.CREATED);

    }
    @PutMapping("/contact/{id}")
    @PreAuthorize("hasAuthority('admin:update')")
    public ResponseEntity<Contact> updateContact(@PathVariable Long id, @RequestBody Contact contact){
        loger.info("Update contact");
        Contact updateContact = contactService.updateContact(id,contact);
        if(updateContact != null){
            return new ResponseEntity<>(updateContact,HttpStatus.OK);

        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/contact/{id}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public ResponseEntity<?> deleteContact(@PathVariable Long id){
        loger.info("Delete contact");
        contactService.deleteContact(id);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


}
