package com.tekarch.flight.TafDatastoreService.Controllers;


import com.tekarch.flight.TafDatastoreService.Models.Flight;
import com.tekarch.flight.TafDatastoreService.Repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightRepository flightRepository;

    // Create flight
    @PostMapping
    public Flight createFlight(@RequestBody Flight flight) {
        flight.setCreatedAt(LocalDateTime.now());
        flight.setUpdatedAt(LocalDateTime.now());
        return flightRepository.save(flight);
    }

    // Get flight by ID
    @GetMapping("/{id}")
    public Flight getFlight(@PathVariable Long id) {
        return flightRepository.findById(id).orElseThrow(() -> new RuntimeException("Flight not found"));
    }

    // Update flight
    @PutMapping("/{id}")
    public Flight updateFlight(@PathVariable Long id, @RequestBody Flight flight) {
        Flight existingFlight = flightRepository.findById(id).orElseThrow(() -> new RuntimeException("Flight not found"));
        existingFlight.setFlightNumber(flight.getFlightNumber());
        existingFlight.setDeparture(flight.getDeparture());
        existingFlight.setArrival(flight.getArrival());
        existingFlight.setDepartureTime(flight.getDepartureTime());
        existingFlight.setArrivalTime(flight.getArrivalTime());
        existingFlight.setPrice(flight.getPrice());
        existingFlight.setAvailableSeats(flight.getAvailableSeats());
        existingFlight.setUpdatedAt(LocalDateTime.now());
        return flightRepository.save(existingFlight);
    }

    // Delete flight
    @DeleteMapping("/{id}")
    public void deleteFlight(@PathVariable Long id) {
        flightRepository.deleteById(id);
    }

    // Get all flights
    @GetMapping
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }
}