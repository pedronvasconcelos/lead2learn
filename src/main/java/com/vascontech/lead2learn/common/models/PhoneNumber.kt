package com.vascontech.lead2learn.common.models

data class PhoneNumber  constructor(val number: String) {
    companion object {
        private val PHONE_REGEX = Regex("^\\+?[1-9]\\d{1,14}\$")

        fun of(number: String): PhoneNumber {
            val cleanNumber = number.replace(Regex("[^+\\d]"), "")
            if (!PHONE_REGEX.matches(cleanNumber)) {
                throw InvalidPhoneNumberException("Invalid phone number")
            }
            return PhoneNumber(cleanNumber)
        }
    }

    fun format(): String {
        return when {
            number.startsWith("+55") -> formatBrazilianNumber()
            else -> number
        }
    }

    private fun formatBrazilianNumber(): String {
        val numberWithoutCountryCode = number.substring(3)
        return when (numberWithoutCountryCode.length) {
            10 -> "(${numberWithoutCountryCode.substring(0, 2)}) ${numberWithoutCountryCode.substring(2, 6)}-${numberWithoutCountryCode.substring(6)}"
            11 -> "(${numberWithoutCountryCode.substring(0, 2)}) ${numberWithoutCountryCode.substring(2, 7)}-${numberWithoutCountryCode.substring(7)}"
            else -> number
        }
    }


    override fun toString(): String {
        return number
    }
}

class InvalidPhoneNumberException(message: String) : IllegalArgumentException(message)