package com.example.room.reservations.service

import com.example.room.reservations.dto.CustomerDto
import com.example.room.reservations.entity.RoomReservation
import com.example.room.reservations.mapper.CustomerMapper
import com.example.room.reservations.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(private val customerRepository: CustomerRepository) {

    fun getCustomers(): List<RoomReservation> {
        return customerRepository.findAll()
    }

    fun save(customerDto: CustomerDto): RoomReservation {
        val roomReservation = CustomerMapper.toEntity(customerDto)
        return customerRepository.save(roomReservation)
    }
}

