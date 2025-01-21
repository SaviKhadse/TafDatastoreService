package com.tekarch.flight.TafDatastoreService.Repositories;

import com.tekarch.flight.TafDatastoreService.Models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}