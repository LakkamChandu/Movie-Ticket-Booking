package com.example.movie_ticket.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.movie_ticket.Model.Booking;
import com.example.movie_ticket.Service.BookingService;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;
    public BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }

    @PostMapping
    public Booking createBooking(
        @RequestParam Long movieId, 
        @RequestParam String customerName, 
        @RequestParam int seats){
            return  bookingService.createBooking(movieId, customerName, seats);     
    }

    @GetMapping("/{bookingId}")
    public Booking getBookingById(@PathVariable Long bookingId){
        return bookingService.getBookingById(bookingId);
    }

    @GetMapping
    public List<Booking> getAllBokings(){
        return bookingService.getAllBookings();
    }
    
    @DeleteMapping("/{bookingId}")
    public void cancelBooking(@PathVariable Long bookingId){
        bookingService.cancelBooking(bookingId);
    }

}
