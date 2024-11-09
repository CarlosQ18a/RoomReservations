package com.example.room.reservations.repository

import com.example.room.reservations.entity.RoomReservation
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository : JpaRepository<RoomReservation, Long>
