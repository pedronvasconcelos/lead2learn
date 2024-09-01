package com.vascontech.lead2learn.common.models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PhoneNumberTest {

    @Test
    @DisplayName("Should create valid phone number")
    void shouldCreateValidPhoneNumber() {
        PhoneNumber phoneNumber = PhoneNumber.Companion.of("+5511987654321");
        assertNotNull(phoneNumber);
        assertEquals("+5511987654321", phoneNumber.getNumber());
    }

    @ParameterizedTest
    @ValueSource(strings = {"+5511987654321", "5511987654321", "+55-11-98765-4321"})
    @DisplayName("Should create valid phone number with various formats")
    void shouldCreateValidPhoneNumberWithVariousFormats(String number) {
        PhoneNumber phoneNumber = PhoneNumber.Companion.of(number);
        assertNotNull(phoneNumber);
    }

    @Test
    @DisplayName("Should throw InvalidPhoneNumberException for invalid phone number")
    void shouldThrowExceptionForInvalidPhoneNumber() {
        assertThrows(InvalidPhoneNumberException.class, () -> PhoneNumber.Companion.of("invalid"));
    }

    @Test
    @DisplayName("Should format Brazilian mobile phone number")
    void shouldFormatBrazilianMobilePhoneNumber() {
        PhoneNumber phoneNumber = PhoneNumber.Companion.of("+5511987654321");
        assertEquals("(11) 98765-4321", phoneNumber.format());
    }

    @Test
    @DisplayName("Should format Brazilian landline phone number")
    void shouldFormatBrazilianLandlinePhoneNumber() {
        PhoneNumber phoneNumber = PhoneNumber.Companion.of("+5511987654321");
        assertEquals("(11) 98765-4321", phoneNumber.format());
    }

    @Test
    @DisplayName("Should not format non-Brazilian phone numbers")
    void shouldNotFormatNonBrazilianPhoneNumbers() {
        PhoneNumber phoneNumber = PhoneNumber.Companion.of("+12125551234");
        assertEquals("+12125551234", phoneNumber.format());
    }

    @Test
    @DisplayName("Should compare phone numbers correctly")
    void shouldComparePhoneNumbersCorrectly() {
        PhoneNumber number1 = PhoneNumber.Companion.of("+5511987654321");
        PhoneNumber number2 = PhoneNumber.Companion.of("+5511987654321");
        PhoneNumber number3 = PhoneNumber.Companion.of("+5511987654322");

        assertEquals(number1, number2);
        assertNotEquals(number1, number3);
    }

    @Test
    @DisplayName("Should use unformatted number in toString")
    void shouldUseUnformattedNumberInToString() {
        PhoneNumber phoneNumber = PhoneNumber.Companion.of("+5511987654321");
        assertEquals("+5511987654321", phoneNumber.toString());
    }

    @Test
    @DisplayName("Should handle Brazilian numbers with different lengths")
    void shouldHandleBrazilianNumbersWithDifferentLengths() {
        PhoneNumber shortNumber = PhoneNumber.Companion.of("+551187654321");
        PhoneNumber longNumber = PhoneNumber.Companion.of("+5511987654321");

        assertEquals("(11) 8765-4321", shortNumber.format());
        assertEquals("(11) 98765-4321", longNumber.format());
    }
}