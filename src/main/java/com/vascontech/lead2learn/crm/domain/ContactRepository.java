package com.vascontech.lead2learn.crm.domain;

import java.util.UUID;

public interface ContactRepository {
    boolean existsByEmail(String email);
    Contact save(Contact contact);
    Contact findById(UUID id);
 }
