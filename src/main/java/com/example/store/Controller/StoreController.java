package com.example.store.Controller;

import com.example.store.Model.Store;
import com.example.store.Service.StoreService;
import com.example.store.dto.StoreDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stores")
public class StoreController {

    @Autowired
    private StoreService storeService;


    @PostMapping("/register")
    public ResponseEntity<?> registerStore(@RequestBody StoreDTO storeDTO) {
        try {
            storeService.registerStore(storeDTO);
            return ResponseEntity.ok("매장 등록 성공");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("매장 등록 실패: " + e.getMessage());
        }
    }

    @GetMapping("/{storeId}")
    public ResponseEntity<?> getStoreById(@PathVariable Long storeId) {
        try {
            Store store = storeService.getStoreById(storeId);
            if (store != null) {
                return ResponseEntity.ok(store);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("매장 조회 실패: " + e.getMessage());
        }
    }

}