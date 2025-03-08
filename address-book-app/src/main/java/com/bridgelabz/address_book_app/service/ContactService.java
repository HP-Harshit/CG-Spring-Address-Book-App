package com.bridgelabz.address_book_app.service;

import com.bridgelabz.address_book_app.dto.ContactDTO;
import com.bridgelabz.address_book_app.model.Contact;
import com.bridgelabz.address_book_app.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService implements IContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Contact createContact(ContactDTO contactDTO) {
        Contact contact = new Contact();
        contact.setFullname(contactDTO.getFullname());
        contact.setAddress(contactDTO.getAddress());
        contact.setCity(contactDTO.getCity());
        contact.setState(contactDTO.getState());
        contact.setZipcode(contactDTO.getZipcode());
        contact.setPhonenumber(contactDTO.getPhonenumber());
        return contactRepository.save(contact);
    }

    @Override
    public Optional<Contact> getContactById(Long id) {
        return contactRepository.findById(id);
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Contact updateContact(Long id, ContactDTO contactDTO) {
        Optional<Contact> contactOptional = contactRepository.findById(id);
        if (contactOptional.isPresent()) {
            Contact contact = contactOptional.get();
            contact.setFullname(contactDTO.getFullname());
            contact.setAddress(contactDTO.getAddress());
            contact.setCity(contactDTO.getCity());
            contact.setState(contactDTO.getState());
            contact.setZipcode(contactDTO.getZipcode());
            contact.setPhonenumber(contactDTO.getPhonenumber());
            return contactRepository.save(contact);
        } else {
            return null;
        }
    }

    @Override
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }
}
