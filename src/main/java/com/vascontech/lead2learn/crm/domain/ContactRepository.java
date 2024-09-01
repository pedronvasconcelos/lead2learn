package com.vascontech.lead2learn.crm.domain;

public interface ContactRepository {
    boolean existsByEmail(String email);
    Contact save(Contact contact);
}
