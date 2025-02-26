package com.bridgelabz.address_book_app.controller;

import com.bridgelabz.address_book_app.dto.ContactDTO;
import com.bridgelabz.address_book_app.exception.AddressBookNotFoundException;
import com.bridgelabz.address_book_app.model.Contact;
import com.bridgelabz.address_book_app.service.IContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/addressbook")
@Slf4j
public class ContactController {

    @Autowired
    private IContactService contactService;

    @GetMapping("/")
    public List<Contact> getAllContacts() {
        log.info("Getting all contacts");
        return contactService.getAllContacts();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable Long id) {
        log.info("Getting contact with ID: {}", id);
        return contactService.getContactById(id)
                .map(contact -> new ResponseEntity<>(contact, HttpStatus.OK))
                .orElseThrow(() -> new AddressBookNotFoundException("Address Book entry not found with ID: " + id));
    }

    @PostMapping("/create")
    public Contact createContact(@Valid @RequestBody ContactDTO contactDTO) {
        log.info("Creating contact: {}", contactDTO);
        return contactService.createContact(contactDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable Long id, @Valid @RequestBody ContactDTO contactDTO) {
        log.info("Updating contact with ID: {}", id);
        Contact updatedContact = contactService.updateContact(id, contactDTO);
        if (updatedContact != null) {
            return new ResponseEntity<>(updatedContact, HttpStatus.OK);
        } else {
            throw new AddressBookNotFoundException("Address Book entry not found with ID: " + id);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        log.info("Deleting contact with ID: {}", id);
        contactService.deleteContact(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
