package com.bridgelabz.address_book_app.repository;

import com.bridgelabz.address_book_app.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
