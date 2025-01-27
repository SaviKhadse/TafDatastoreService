package com.tekarch.flight.TafDatastoreService.Repositories;

import com.tekarch.flight.TafDatastoreService.Models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    @NativeQuery(value = "select * from bookings b where b.user_id = ?1")
    List<Booking> findBookingsByUserId(Long userId);
}