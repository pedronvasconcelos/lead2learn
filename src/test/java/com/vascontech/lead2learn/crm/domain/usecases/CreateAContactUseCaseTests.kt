package com.vascontech.lead2learn.crm.domain.usecases

import com.vascontech.lead2learn.crm.domain.ContactBuilder
import com.vascontech.lead2learn.crm.domain.ContactRepository
import com.vascontech.lead2learn.crm.domain.models.CreateAContactRequest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import org.junit.jupiter.api.Assertions.*

class CreateAContactUseCaseTest {

    private lateinit var contactRepository: ContactRepository
    private lateinit var createAContactUseCase: CreateAContactUseCase

    @BeforeEach
    fun setUp() {
        contactRepository = mock(ContactRepository::class.java)
        createAContactUseCase =
            CreateAContactUseCase(contactRepository)
    }

    @Test
    fun `execute should create contact when it doesn't exist`() {
        // Arrange
        val request = CreateAContactRequest(
            "John",
            "Doe",
            "john@example.com"
        )
        val savedContact = ContactBuilder().setFirstName("John").setLastName("Doe").setEmail("john@example.com").createContact()

        `when`(contactRepository.existsByEmail("john@example.com")).thenReturn(false)
        `when`(contactRepository.save(any())).thenReturn(savedContact)

        // Act
        val response = createAContactUseCase.execute(request)

        // Assert
        assertTrue(response.success)
        assertEquals("Contact created successfully", response.message)
        verify(contactRepository).save(any())
    }

    @Test
    fun `execute should not create contact when it already exists`() {
        // Arrange
        val request = CreateAContactRequest(
            "John",
            "Doe",
            "john@example.com"
        )
        `when`(contactRepository.existsByEmail("john@example.com")).thenReturn(true)

        // Act
        val response = createAContactUseCase.execute(request)

        // Assert
        assertFalse(response.success)
        assertNull(response.id)
        assertEquals("Contact already exists", response.message)
        verify(contactRepository, never()).save(any())
    }

    @Test
    fun `execute should throw exception when repository fails`() {
        // Arrange
        val request = CreateAContactRequest(
            "John",
            "Doe",
            "john@example.com"
        )
        `when`(contactRepository.existsByEmail("john@example.com")).thenReturn(false)
        `when`(contactRepository.save(any())).thenThrow(RuntimeException("Database error"))

        // Act & Assert
        assertThrows(RuntimeException::class.java) {
            createAContactUseCase.execute(request)
        }
    }
}