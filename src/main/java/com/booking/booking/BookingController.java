package com.booking.booking;

import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.pojo.ApiStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/bookings")
@Api(name="Hotel Booking API", description = "provides a list of methods that manage hotel bookings", stage = ApiStage.ALPHA)
public class BookingController {

    private BookingRepository bookingRepository;

    @Autowired
    public BookingController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ApiMethod(description = "Get all hotel bookings from the database")
    public List<HotelBooking> getAll() {
    return bookingRepository.findAll();
    }

    @RequestMapping(value = "/affordable/{price}", method = RequestMethod.GET)
    @ApiMethod(description = "Get all hotel bookings where the price per night is less than the provided value")
    public List<HotelBooking> getAffordableRoom(@ApiPathParam(name="price") @PathVariable double price) {
        //return this.bookings.stream().filter(x -> x.getPricePerNight() < price).collect(Collectors.toList());
        return bookingRepository.findByPricePerNightLessThan(price);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ApiMethod(description = "create a hotel booking and save it to the database")
    public List<HotelBooking> create(@RequestBody HotelBooking hotelBooking) {
        //this.bookings.add(hotelBooking);
        //return this.bookings;
        bookingRepository.save(hotelBooking);
        return bookingRepository.findAll();
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.POST)
    @ApiMethod(description = "Remove the hotel booking with the provided ID from the database")
    public List<HotelBooking>remove(@ApiPathParam(name="id") @PathVariable long id){
        bookingRepository.delete(id);
        return bookingRepository.findAll();

    }


}
