package com.booking.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class DatabaseSeeder implements CommandLineRunner {
    private BookingRepository bookingRepository;

    @Autowired
    public DatabaseSeeder(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        List<HotelBooking> bookings = new ArrayList<>();
        bookings.add(new HotelBooking("Meriot", 200.5, 2));
        bookings.add(new HotelBooking("IBIS", 105.20, 4));
        bookings.add(new HotelBooking("La Royale", 90, 1));

        bookingRepository.save(bookings);
    }
}
