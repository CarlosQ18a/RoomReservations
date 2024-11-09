package com.example.room.reservations.entity

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate

@Entity
@Table(name = "room_reservations")
class RoomReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(name = "room_number", nullable = false)
    var roomNumber: String? = null

    @Column(nullable = false)
    var type: String? = null

    @Column(nullable = false)
    var price: BigDecimal? = null

    @Column
    var customer: String? = null

    @Column(name = "check_in")
    var checkIn: LocalDate? = null

    @Column(name = "check_out")
    var checkOut: LocalDate? = null

    @Column(nullable = false)
    var status: String? = null
}
