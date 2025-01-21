package com.tekarch.flight.TafDatastoreService.Controllers;

//import com.tekarch.flight.TafDatastoreService.DTO.BookingResponseDTO;
import com.tekarch.flight.TafDatastoreService.Models.Booking;
import com.tekarch.flight.TafDatastoreService.Models.User;
import com.tekarch.flight.TafDatastoreService.Repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    Logger logger = LogManager.getLogger(BookingController.class);

    @Autowired
    private BookingRepository bookingRepository;

    // Create booking
    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        logger.info("Booking userId "+booking.getUser());
        booking.setCreatedAt(LocalDateTime.now());
        booking.setUpdatedAt(LocalDateTime.now());

        Booking savedBooking= bookingRepository.save(booking);
//        logger.info("savedBookingResponse "+savedBookingResponse.getUser());
//        return new BookingResponseDTO(savedBookingResponse.getId(), savedBookingResponse.getUser().getId(),
//                savedBookingResponse.getFlight().getId() ,savedBookingResponse.getStatus());
        return savedBooking;
    }

    // Get booking by ID
    @GetMapping("/{id}")
    public Booking getBooking(@PathVariable Long id) {
        return bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking not found"));
    }

    // Get all bookings
    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // Delete booking
    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Long id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking Id not found"));

        booking.setStatus("Cancelled");
        booking.setUpdatedAt(LocalDateTime.now());
        bookingRepository.save(booking);
//        bookingRepository.deleteById(id);
    }
    
}