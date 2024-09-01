package com.vascontech.lead2learn.common.models

class PhoneNumber(number: String?) {
    val number: String

    init {
        this.number = when {
            number.isNullOrBlank() -> ""
            else -> {
                val cleanNumber = number.replace(Regex("[^+\\d]"), "")
                when {
                    PHONE_REGEX.matches(cleanNumber) -> cleanNumber
                    else -> throw InvalidPhoneNumberException("Invalid phone number")
                }
            }
        }
    }

    companion object {
        private val PHONE_REGEX = Regex("^\\+?[1-9]\\d{1,14}\$")

        fun of(number: String?): PhoneNumber {
            return PhoneNumber(number)
        }
    }

    fun format(): String {
        return when {
            number.isBlank() -> ""
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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as PhoneNumber

        if (number != other.number) return false

        return true
    }
}

class InvalidPhoneNumberException(message: String) : IllegalArgumentException(message)