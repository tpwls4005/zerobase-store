package com.example.store.Controller;

import com.example.store.Model.Reservation;
import com.example.store.Service.ReservationService;
import com.example.store.dto.ReservationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/make")
    public ResponseEntity<?> makeReservation(@RequestBody ReservationDTO reservationDTO) {
        try {
            reservationService.makeReservation(reservationDTO);
            return ResponseEntity.ok("예약 생성 성공");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("예약 생성 실패: " + e.getMessage());
        }
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAllReservations() {
        try {
            List<Reservation> reservations = reservationService.getAllReservations();
            return ResponseEntity.ok(reservations);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "예약 목록 조회 실패: " + e.getMessage());
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }


}
