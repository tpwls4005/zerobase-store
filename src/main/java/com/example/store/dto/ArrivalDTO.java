package com.example.store.dto;

public class ArrivalDTO {
    private Long reservationId;
    private boolean confirmed;


    public ArrivalDTO() {
    }

    public ArrivalDTO(Long reservationId, boolean confirmed) {
        this.reservationId = reservationId;
        this.confirmed = confirmed;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }
}
