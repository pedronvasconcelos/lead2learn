package com.vascontech.lead2learn.crm.infra.repository;

import com.vascontech.lead2learn.crm.domain.Contact;
import com.vascontech.lead2learn.crm.domain.ContactRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class InMemoryContactRepository implements ContactRepository {

    private final Map<String, Contact> contactStorage = new HashMap<>();

    @Override
    public boolean existsByEmail(String email) {
        return contactStorage.containsKey(email);
    }

    @Override
    public Contact save(Contact contact) {
        contactStorage.put(contact.getEmail(), contact);
        return contact;
    }

    @Override
    public Contact findById(UUID id) {
        return contactStorage.values().stream()
            .filter(contact -> contact.getId().equals(id))
            .findFirst()
            .orElse(null);
    }
}