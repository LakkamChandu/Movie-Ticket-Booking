package com.example.movie_ticket.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.movie_ticket.Exception.ResourceNotFoundException;
import com.example.movie_ticket.Exception.BadRequestException;
import com.example.movie_ticket.Model.Booking;
import com.example.movie_ticket.Model.Showtime;
import com.example.movie_ticket.Repository.BookingRepo;
import com.example.movie_ticket.Repository.ShowtimeRepo;
import jakarta.transaction.Transactional;

@Service
public class BookingServiceImpl implements BookingService{

    private final BookingRepo bookingRepo;
    private final ShowtimeRepo showtimeRepo;

    public BookingServiceImpl(BookingRepo bookingRepo, ShowtimeRepo showtimeRepo){
        this.bookingRepo = bookingRepo;
        this.showtimeRepo = showtimeRepo;
    }

    @Override
    @Transactional
    public Booking createBooking(Long showtimeId, String customerName, int seats){
      Showtime  showTime = showtimeRepo.findById(showtimeId).orElseThrow(() -> new ResourceNotFoundException("No Showtime found with this id : " + showtimeId));

      if(showTime.getAvailableSeats() < seats){
        throw new BadRequestException("Not enough seats available...");
      }

      //reducing seats
       showTime.setAvailableSeats(showTime.getAvailableSeats() - seats);
       showtimeRepo.save(showTime);

       //calculate price
       BigDecimal totalPrice = showTime.getPrice().multiply(BigDecimal.valueOf(seats));

       Booking booking = Booking.builder()
       .customerName(customerName)
       .seatsBooked(seats)
       .price(totalPrice)
       .bookingTime(LocalDateTime.now())
       .showTime(showTime)
       .build();
       return bookingRepo.save(booking);
    }

    @Override
    public Booking getBookingById(Long id){
        return bookingRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Booking Id not found with this id : " + id));
    }

    @Override
    public List<Booking> getAllBookings(){
        return bookingRepo.findAll();
    }

    @Override
    public void cancelBooking(Long bookingId){
        bookingRepo.deleteById(bookingId);
    }


}
