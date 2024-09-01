package com.vascontech.lead2learn.crm.web.controllers.v1;


import com.vascontech.lead2learn.crm.domain.models.CreateAContactRequest;
import com.vascontech.lead2learn.crm.domain.models.CreateAContactResponse;
import com.vascontech.lead2learn.crm.domain.models.UpdateContactPhoneNumberResponse;
import com.vascontech.lead2learn.crm.domain.usecases.CreateAContactUseCase;
import com.vascontech.lead2learn.crm.domain.usecases.UpdateContactPhoneNumberUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@RequestMapping("/crm/api/v1/contacts")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "CRM", description = "Create a contact")

public class ContactController {
    private final CreateAContactUseCase createAContactUseCase;
    private final UpdateContactPhoneNumberUseCase updateContactPhoneNumberUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a contact")
    public CreateAContactResponse createContact(@RequestBody CreateAContactRequest request) {
        log.info("Creating contact with email: {}", request.email);
        var response =  createAContactUseCase.execute(request);
        if(!response.success) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, response.message);
        }
        return response;
    }

    @PutMapping("/{id}/phone-number")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update contact phone number")
    public UpdateContactPhoneNumberResponse updateContactPhoneNumber(@PathVariable UUID id, @RequestParam String phoneNumber) {
        log.info("Updating contact with id: {}", id);
        return updateContactPhoneNumberUseCase.execute(id, phoneNumber);
    }
}
