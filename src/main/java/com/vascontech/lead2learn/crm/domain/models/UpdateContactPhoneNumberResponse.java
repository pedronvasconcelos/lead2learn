package com.vascontech.lead2learn.crm.domain.models;

public class UpdateContactPhoneNumberResponse {
    public boolean success;
    public String message;

    public UpdateContactPhoneNumberResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }


}
