package com.vascontech.lead2learn.common.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmailTests {

    @Test
    void shouldCreateValidEmail() {
        Email email = new Email("test@example.com");
        assertEquals("test@example.com", email.getValue());
    }

    @Test
    void shouldThrowExceptionForEmptyEmail() {
        assertThrows(EmailInvalidException.class, () -> new Email(""));
    }

    @Test
    void shouldThrowExceptionForEmailWithoutAtSymbol() {
        assertThrows(EmailInvalidException.class, () -> new Email("testexample.com"));
    }

    @Test
    void staticValidationShouldAcceptValidEmail() {
        assertDoesNotThrow(() -> Email.Companion.validateEmail("test@example.com"));
    }

    @Test
    void staticValidationShouldThrowExceptionForInvalidEmail() {
        assertThrows(EmailInvalidException.class, () -> Email.Companion.validateEmail("invalid-email"));
    }
}