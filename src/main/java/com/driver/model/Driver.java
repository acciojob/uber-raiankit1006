package com.driver.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "drivers")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int driverId;
    private String mobile;
    private String password;
    public Driver(){}

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverID) {
        this.driverId = driverId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
    private List<TripBooking> tripBookingsList = new ArrayList<>();

    public List<TripBooking> getTripBookingsList() {
        return tripBookingsList;
    }

    public void setTripBookingsList(List<TripBooking> tripBookingsList) {
        this.tripBookingsList = tripBookingsList;
    }

    public Cab getCab() {
        return cab;
    }

    public void setCab(Cab cab) {
        this.cab = cab;
    }

    @OneToOne(mappedBy = "driver", cascade = CascadeType.ALL)
    private Cab cab;



}