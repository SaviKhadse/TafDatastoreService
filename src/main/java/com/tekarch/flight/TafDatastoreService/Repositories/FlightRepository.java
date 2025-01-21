package com.tekarch.flight.TafDatastoreService.Repositories;

import com.tekarch.flight.TafDatastoreService.Models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}