package com.example.store.Service;

import com.example.store.Model.Arrival;
import com.example.store.Repository.ArrivalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArrivalService {

    @Autowired
    private ArrivalRepository arrivalRepository;

    public void confirmArrival(Long reservationId) {
        // 도착 확인 로직 구현
        Arrival arrival = new Arrival();
        arrival.setReservationId(reservationId);
        arrival.setConfirmed(true);

        arrivalRepository.save(arrival);
    }

    public List<Arrival> getAllArrivals() {
        // 도착 목록 조회 로직 구현
        return arrivalRepository.findAll();
    }

    // 다른 도착 관련 서비스 메서드들 추가 가능
}
