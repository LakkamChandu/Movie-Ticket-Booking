package com.example.movie_ticket.Service;

import java.util.List;
import com.example.movie_ticket.Model.Booking;


public interface BookingService {

    Booking createBooking(Long showtimeId, String customerName, int seats);

    Booking getBookingById(Long bookingId);

    List<Booking> getAllBookings();
    
    void cancelBooking(Long bookingId);

    

}
