package com.example.room.reservations.controller

import com.example.room.reservations.dto.CustomerDto
import com.example.room.reservations.entity.RoomReservation
import com.example.room.reservations.service.CustomerService
import com.example.sistema.response.JSendResponse
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/customer")
class CustomerController(private val customerService: CustomerService) {

    @GetMapping
    fun getCustomers() = JSendResponse.success(customerService.getCustomer())

    @PostMapping
    fun save(@RequestBody @Valid customerDto: CustomerDto): JSendResponse {
        val roomReservation = customerService.save(customerDto)
        return JSendResponse.success(roomReservation)
    }
}
