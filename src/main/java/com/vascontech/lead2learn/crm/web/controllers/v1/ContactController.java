package com.vascontech.lead2learn.crm.web.controllers.v1;


import com.vascontech.lead2learn.crm.domain.CreateAContactRequest;
import com.vascontech.lead2learn.crm.domain.CreateAContactResponse;
import com.vascontech.lead2learn.crm.domain.CreateAContactUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/crm/api/v1/contacts")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "CRM", description = "Create a contact")

public class ContactController {
    private final CreateAContactUseCase createAContactUseCase;

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
}
