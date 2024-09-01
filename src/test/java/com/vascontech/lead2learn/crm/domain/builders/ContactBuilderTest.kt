package com.vascontech.lead2learn.crm.domain.builders


import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows

class ContactBuilderTest {

    @Test
    @DisplayName("Should create contact with all fields set")
    fun shouldCreateContactWithAllFields() {
        val contact = ContactBuilder()
            .setFirstName("John")
            .setLastName("Doe")
            .setEmail("john.doe@example.com")
            .setPhoneNumber("+5531943141512")
            .createContact()

        assertAll(
            { assertEquals("John Doe", contact.fullName) },
            { assertEquals("john.doe@example.com", contact.email) },
            { assertEquals("+5531943141512", contact.phoneNumber) }
        )
    }

    @Test
    @DisplayName("Should create contact without phone number")
    fun shouldCreateContactWithoutPhoneNumber() {
        val contact = ContactBuilder()
            .setFirstName("Jane")
            .setLastName("Doe")
            .setEmail("jane.doe@example.com")
            .createContact()

        assertAll(
            { assertEquals("Jane", contact.firstName) },
            { assertEquals("Doe", contact.lastName) },
            { assertEquals("jane.doe@example.com", contact.email) },
            { assertEquals("", contact.phoneNumber) }
        )
    }

    @Test
    @DisplayName("Should create contact with minimal required fields")
    fun shouldCreateContactWithMinimalFields() {
        val contact = ContactBuilder()
            .setFirstName("Alice")
            .setLastName("Smith")
            .setEmail("alice.smith@example.com")
            .createContact()

        assertAll(
            { assertEquals("Alice", contact.firstName) },
            { assertEquals("Smith", contact.lastName) },
            { assertEquals("alice.smith@example.com", contact.email) },
            { assertEquals("", contact.phoneNumber) },
            { assertFalse(contact.isBecomeCustomer) }
        )
    }

    @Test
    @DisplayName("Should throw exception when creating contact without required fields")
    fun shouldThrowExceptionWhenMissingRequiredFields() {
        val builder = ContactBuilder()
            .setFirstName("Bob")
            .setLastName("Johnson")

        assertThrows<IllegalArgumentException> {
            builder.createContact()
        }
    }

    @Test
    @DisplayName("Should create unique contacts with different IDs")
    fun shouldCreateUniqueContactsWithDifferentIds() {
        val contact1 = ContactBuilder()
            .setFirstName("Contact")
            .setLastName("One")
            .setEmail("contact.one@example.com")
            .createContact()

        val contact2 = ContactBuilder()
            .setFirstName("Contact")
            .setLastName("Two")
            .setEmail("contact.two@example.com")
            .createContact()

        assertNotEquals(contact1.id, contact2.id)
    }
}