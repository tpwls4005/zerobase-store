package com.example.store.Service;

import com.example.store.Model.Reservation;
import com.example.store.Repository.ReservationRepository;
import com.example.store.dto.ReservationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public void makeReservation(ReservationDTO reservationDTO) {
        // ReservationDTO를 Reservation 엔티티로 변환 후 저장
        Reservation reservation = new Reservation();
        reservation.setReservationDetails(reservationDTO.getReservationDetails());
        // 필요한 다른 정보 설정

        reservationRepository.save(reservation);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

}
