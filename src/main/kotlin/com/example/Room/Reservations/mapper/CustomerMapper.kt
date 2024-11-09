package com.example.Room.Reservations.mapper
import com.example.room.reservations.dto.CustomerDto
import com.example.room.reservations.entity.RoomReservation

object CustomerMapper {
    fun toEntity(customerDto: CustomerDto): RoomReservation {
        val roomReservation = RoomReservation()
        roomReservation.customer = customerDto.fullName
        roomReservation.roomNumber = customerDto.email
        roomReservation.type = customerDto.type
        roomReservation.price = customerDto.price
        roomReservation.customer = customerDto.roomNumber
        roomReservation.checkIn = customerDto.checkIn
        roomReservation.checkOut = customerDto.checkOut
        roomReservation.status = customerDto.status
        return roomReservation
    }
}


