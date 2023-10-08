package com.example.store.Model;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reservationDetails;

    public void setId(Long id) {
        this.id = id;
    }

    public void setReservationDetails(String reservationDetails) {
        this.reservationDetails = reservationDetails;
    }


}
