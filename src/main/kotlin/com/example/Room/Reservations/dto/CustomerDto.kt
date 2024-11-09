package com.example.room.reservations.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal
import java.time.LocalDate

class CustomerDto {

    @NotNull(message = "Full name is required")
    @NotBlank(message = "Full name cannot be blank")
    var fullName: String? = null

    @NotNull(message = "Email is required")
    @NotBlank(message = "Email cannot be blank")
    var email: String? = null

    // Campos adicionales
    var roomNumber: String? = null
    var type: String? = null
    var price: BigDecimal? = null
    var checkIn: LocalDate? = null
    var checkOut: LocalDate? = null
    var status: String? = null
}

