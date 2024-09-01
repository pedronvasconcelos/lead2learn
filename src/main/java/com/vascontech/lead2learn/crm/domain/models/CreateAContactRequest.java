package com.vascontech.lead2learn.crm.domain.models;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema
public class CreateAContactRequest {
    public String firstName;
    public String lastName;
    public String email;

    public CreateAContactRequest(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

}
