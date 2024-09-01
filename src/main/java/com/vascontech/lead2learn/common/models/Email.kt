package com.vascontech.lead2learn.common.models

class Email(val value: String) {

    init {
        validateEmail()
    }

    private fun validateEmail() {
        if (value.isBlank()) {
            throw EmailInvalidException("Email cannot be empty")
        }
        if (!value.contains("@")) {
            throw EmailInvalidException("Invalid email format")
        }
    }

    companion object {
        fun validateEmail(email: String) {
            Email(email)
        }
    }
}


class EmailInvalidException(message: String) : IllegalArgumentException(message)