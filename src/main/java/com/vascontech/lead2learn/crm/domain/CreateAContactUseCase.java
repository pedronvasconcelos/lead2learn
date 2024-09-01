package com.vascontech.lead2learn.crm.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Transactional
@Service
public class CreateAContactUseCase {

    private final ContactRepository contactRepository;



    public CreateAContactResponse execute(CreateAContactRequest request) {
        var contactExists = contactRepository.existsByEmail(request.email);
        if(contactExists) {
            return new CreateAContactResponse(null, false, "Contact already exists");
        }

        var contact = new ContactBuilder()
            .setFirstName(request.firstName)
            .setLastName(request.lastName)
            .setEmail(request.email)
            .createContact();
        contactRepository.save(contact);
        return new CreateAContactResponse(contact.getId(), true, "Contact created successfully");

    }
}
