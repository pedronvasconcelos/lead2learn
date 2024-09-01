package com.vascontech.lead2learn.crm.domain;

import com.vascontech.lead2learn.common.models.Email;
import com.vascontech.lead2learn.common.models.PhoneNumber;

import java.time.LocalDate;
import java.util.UUID;

public class Contact {
    private UUID id;
    private  String firstName;
    private  String lastName;
    private Email email;
    private PhoneNumber phoneNumber;
    private String notes;
    private LocalDate lastContactDate;
    private boolean becomeCustomer;

    public Contact(String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = new Email(email);
        LocalDate createdAt = LocalDate.now();
        this.id = UUID.randomUUID();
        this.becomeCustomer = false;
        this.phoneNumber = new PhoneNumber(phoneNumber);

    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email.getValue();
    }
    public String getPhoneNumber() {
        return phoneNumber.getNumber();
    }
    public String getFullName() {
        return firstName + " " + lastName;
    }
    public boolean isBecomeCustomer() {
        return becomeCustomer;
    }
    public UUID getId() {
        return id;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = new PhoneNumber(phoneNumber);
    }

}