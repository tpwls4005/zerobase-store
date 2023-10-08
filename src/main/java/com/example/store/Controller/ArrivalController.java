package com.example.store.Controller;

import com.example.store.Model.Arrival;
import com.example.store.Service.ArrivalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/arrivals")
public class ArrivalController {

    @Autowired
    private ArrivalService arrivalService;

    @PostMapping("/confirm")
    public ResponseEntity<?> confirmArrival(@RequestParam Long reservationId) {
        try {
            arrivalService.confirmArrival(reservationId);
            return ResponseEntity.ok("도착 확인 완료");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("도착 확인 실패: " + e.getMessage());
        }
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAllArrivals() {
        try {
            List<Arrival> arrivals = arrivalService.getAllArrivals();
            return ResponseEntity.ok(arrivals);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "도착 확인 실패: " + e.getMessage());
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }
}