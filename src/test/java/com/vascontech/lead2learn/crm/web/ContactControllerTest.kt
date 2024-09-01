package com.vascontech.lead2learn.crm.web


import com.fasterxml.jackson.databind.ObjectMapper
import com.vascontech.lead2learn.crm.domain.CreateAContactRequest
import com.vascontech.lead2learn.crm.domain.CreateAContactResponse
import com.vascontech.lead2learn.crm.domain.CreateAContactUseCase
import com.vascontech.lead2learn.crm.web.controllers.v1.ContactController
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import java.util.*
//TODO should be rewrite when the real repository is implemented

@WebMvcTest(ContactController::class)
class ContactControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var createAContactUseCase: CreateAContactUseCase

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @Test
    fun `when create contact with valid data then return created status`() {
        val request = CreateAContactRequest("john", "john","john@example.com")
        val response = CreateAContactResponse(UUID.randomUUID() ,true, "Contact created successfully")

        doReturn(response).`when`(createAContactUseCase).execute(any(CreateAContactRequest::class.java))

        mockMvc.perform(post("/crm/api/v1/contacts")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isCreated)
            .andExpect(jsonPath("$.success").value(true))
            .andExpect(jsonPath("$.message").value("Contact created successfully"))
        verify(createAContactUseCase, times(1)).execute(any(CreateAContactRequest::class.java))

    }

    @Test
    fun `when create contact with existing email then return conflict status`() {
        val request = CreateAContactRequest("john", "john","john@example.com")
        val response = CreateAContactResponse(null,false, "Contact created successfully")
        doReturn(response).`when`(createAContactUseCase).execute(any(CreateAContactRequest::class.java))


        mockMvc.perform(post("/crm/api/v1/contacts")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isConflict)
        verify(createAContactUseCase, times(1)).execute(any(CreateAContactRequest::class.java))

    }
}