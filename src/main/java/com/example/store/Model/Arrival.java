package com.example.store.Model;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Arrival {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long reservationId;
    private boolean confirmed;


    public void setId(Long id) {
        this.id = id;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }
}
