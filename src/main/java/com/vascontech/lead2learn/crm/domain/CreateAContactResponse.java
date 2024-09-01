package com.vascontech.lead2learn.crm.domain;

import java.util.UUID;

public class CreateAContactResponse {
    public UUID id;
    public boolean success;
    public String message;

    public CreateAContactResponse(UUID id, boolean success, String message) {
        this.id = id;
        this.success = success;
        this.message = message;
    }

}
