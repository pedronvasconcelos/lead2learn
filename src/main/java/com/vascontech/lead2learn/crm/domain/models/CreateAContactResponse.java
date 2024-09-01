package com.vascontech.lead2learn.crm.domain.models;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema
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
