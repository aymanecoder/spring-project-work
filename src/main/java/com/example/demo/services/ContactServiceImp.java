package com.example.demo.services;

import com.example.demo.entities.Client;
import com.example.demo.entities.Contact;
import com.example.demo.repository.ContactRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactServiceImp implements ContactService{

    private final ContactRepository contactRepository;
    @Override
    public List<Contact> getAllcontacts() {
        return contactRepository.findAll();
    }

    @Override
    public Contact getContactById(Long id) {

            return contactRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Contact not found"));

    }

    @Override
    public Contact addContact(Contact contact) {

        return contactRepository.save(contact);
    }

    @Override
    public Contact updateContact(Long id, Contact contact) {
        Contact existingContact = contactRepository.findById(id).get();
        if (existingContact != null) {
            existingContact.setNom(contact.getNom());
            existingContact.setEmail(contact.getEmail());
            existingContact.setPrenom(contact.getPrenom());
            existingContact.setTelephone(contact.getTelephone());
            existingContact.setFonction(contact.getFonction());
            existingContact.setClient(contact.getClient());
            return contactRepository.save(existingContact);
        }else {
            return null;
        }

    }

    @Override
    public void deleteContact(Long id) {
           contactRepository.deleteById(id);
    }
}
