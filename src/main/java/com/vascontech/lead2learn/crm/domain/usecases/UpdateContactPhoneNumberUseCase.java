package com.vascontech.lead2learn.crm.domain.usecases;

import com.vascontech.lead2learn.crm.domain.ContactRepository;
import com.vascontech.lead2learn.crm.domain.models.UpdateContactPhoneNumberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@RequiredArgsConstructor
@Transactional
@Service
public class UpdateContactPhoneNumberUseCase {
    private final ContactRepository contactRepository;


    public UpdateContactPhoneNumberResponse execute(UUID id, String phoneNumber) {

        var contact = contactRepository.findById(id);
        if(contact == null)  {
            throw new RuntimeException("Contact not found");
        }

        contact.setPhoneNumber(phoneNumber);
        contactRepository.save(contact);
        return new UpdateContactPhoneNumberResponse(true, "Contact phone number updated successfully");
    }
}

