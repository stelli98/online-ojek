package com.OnlineOjek.OnlineOjek.controller;

import com.OnlineOjek.OnlineOjek.model.Booking;
import com.OnlineOjek.OnlineOjek.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
public class BookingController {
    @Autowired
    BookingService bookingService;

    @CrossOrigin @PostMapping("api/bookings")
    public Booking createBooking(@RequestBody  Booking booking){
        return bookingService.createBooking(booking);
    }

    @CrossOrigin @PutMapping("api/bookings/{booking_id}/status/{status_name}")
    public Booking changeBookingStatus(@PathVariable("booking_id") Long booking_id, @PathVariable("status_name") String status_name){
        if(status_name.equals("CANCELLED")){
            return bookingService.cancellBooking(booking_id);
        }else if(status_name.equals("DONE")){
            return bookingService.doneBooking(booking_id);
        }
        return null;
    }

    @CrossOrigin @GetMapping("api/bookings")
    public List<Booking> getAllBooking(){
        return bookingService.getAllBooking();
    }

    @CrossOrigin @GetMapping("api/bookings/{booking_id}")
    public Booking getBooking(@PathVariable ("booking_id") Long booking_id){
        return  bookingService.getBooking(booking_id);
    }

}
