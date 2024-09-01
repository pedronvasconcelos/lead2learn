package com.vascontech.lead2learn.crm.domain;

import com.vascontech.lead2learn.common.models.Email;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Contact {
    private UUID id;
    private String firstName;
    private String lastName;
    private Email email;
    private String phoneNumber;
    private String company;
    private String jobTitle;
    private LocalDate birthDate;
    private List<String> tags;
    private String notes;
    private LocalDate createdAt;
    private LocalDate lastContactDate;

    public Contact(String firstName, String lastName, Email email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.tags = new ArrayList<>();
        this.createdAt = LocalDate.now();
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public Email getEmail() { return email; }
    public void setEmail(Email email) { this.email = email; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public String getJobTitle() { return jobTitle; }
    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }

    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

    public List<String> getTags() { return new ArrayList<>(tags); }
    public void addTag(String tag) { this.tags.add(tag); }
    public void removeTag(String tag) { this.tags.remove(tag); }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public LocalDate getCreatedAt() { return createdAt; }

    public LocalDate getLastContactDate() { return lastContactDate; }
    public void setLastContactDate(LocalDate lastContactDate) { this.lastContactDate = lastContactDate; }

    public String getFullName() {
        return firstName + " " + lastName;
    }

}