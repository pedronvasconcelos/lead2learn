package com.vascontech.lead2learn.crm.domain.builders;

import com.vascontech.lead2learn.crm.domain.models.Contact;

public class ContactBuilder {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    public ContactBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ContactBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ContactBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactBuilder setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Contact createContact() {
        if(firstName == null || lastName == null || email == null) {
            throw new IllegalArgumentException("All fields are required");
        }
        return new Contact(firstName, lastName, email, phoneNumber);
    }
}