package com.vascontech.lead2learn.crm.domain;

import com.vascontech.lead2learn.common.models.Email;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Contact {
    private UUID id;
    private  String firstName;
    private  String lastName;
    private Email email;
    private String phoneNumber;
    private LocalDate birthDate;
    private String notes;
    private LocalDate lastContactDate;
    private boolean becomeCustomer;

    public Contact(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = new Email(email);
        LocalDate createdAt = LocalDate.now();
        this.id = UUID.randomUUID();
        this.becomeCustomer = false;
    }


    public String getFullName() {
        return firstName + " " + lastName;
    }

}