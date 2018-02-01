package com.booking.booking;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by suren on 31/01/2018.
 */
@Entity
public class HotelBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String hotelName;
    private double pricePerNight;
    private int nbOfNigths;

    public HotelBooking() {
    }

    public HotelBooking(String hotelName, double pricePerNight, int nbOfNigths) {
        this.hotelName = hotelName;
        this.pricePerNight = pricePerNight;
        this.nbOfNigths = nbOfNigths;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public int getNbOfNigths() {
        return nbOfNigths;
    }

    public void setNbOfNigths(int nbOfNigths) {
        this.nbOfNigths = nbOfNigths;
    }

    public double getTotaalPrice() {
        return this.getPricePerNight() * this.getNbOfNigths();
    }

    public Long getId() {
        return id;
    }
}
