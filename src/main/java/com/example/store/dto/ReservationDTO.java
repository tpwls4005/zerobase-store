package com.example.store.dto;

import lombok.Getter;

@Getter
public class ReservationDTO {
    private String reservationDetails;
    // 다른 필드들 및 게터/세터 메서드 추가

    // 생성자
    public ReservationDTO() {
    }

    public ReservationDTO(String reservationDetails) {
        this.reservationDetails = reservationDetails;
    }


    public void setReservationDetails(String reservationDetails) {
        this.reservationDetails = reservationDetails;
    }

    // 필요한 다른 게터/세터 메서드 추가
}
