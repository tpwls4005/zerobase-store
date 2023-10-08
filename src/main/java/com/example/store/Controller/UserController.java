package com.example.store.Controller;

import com.example.store.Model.User;
import com.example.store.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


// ...

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User userDTO) {
        try {
            userService.registerUser(userDTO);
            return ResponseEntity.ok("사용자 등록 성공");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("사용자 등록 실패: " + e.getMessage());
        }
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getUserByUsername(@PathVariable String username) {
        try {
            User user = userService.getUserByUsername(username);
            if (user != null) {
                return ResponseEntity.ok(user);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("사용자 조회 실패: " + e.getMessage());
        }
    }
}

