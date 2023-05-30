package com.example.demo.services;

import com.example.demo.entities.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> getAllcontacts();
    Contact getContactById(Long id);

    Contact addContact(Contact contact);
    Contact updateContact(Long id,Contact contact);
    void deleteContact(Long id);
}
