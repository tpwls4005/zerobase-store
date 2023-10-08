package com.example.store.Controller;

import com.example.store.Service.ReviewService;
import com.example.store.dto.ReviewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/write")
    public ResponseEntity<?> writeReview(@RequestBody ReviewDTO reviewDTO) {
        try {
            // 리뷰 작성 로직
            reviewService.writeReview(reviewDTO);
            return ResponseEntity.ok("리뷰 작성 완료");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("리뷰 작성 실패: " + e.getMessage());
        }
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<?> getReviewById(@PathVariable Long reviewId) {
        try {
            // 리뷰 조회 로직
            ReviewDTO review = reviewService.getReviewById(reviewId);
            return ResponseEntity.ok(review);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("리뷰 조회 실패: " + e.getMessage());
        }
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAllReviews() {
        try {
            // 모든 리뷰 목록 조회 로직
            List<ReviewDTO> reviews = reviewService.getAllReviews();
            return ResponseEntity.ok(reviews);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("리뷰 목록 조회 실패: " + e.getMessage());
        }
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<?> updateReview(@PathVariable Long reviewId, @RequestBody ReviewDTO updatedReview) {
        try {
            // 리뷰 업데이트 로직
            reviewService.updateReview(reviewId, updatedReview);
            return ResponseEntity.ok("리뷰 업데이트 완료");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("리뷰 업데이트 실패: " + e.getMessage());
        }
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<?> deleteReview(@PathVariable Long reviewId) {
        try {
            // 리뷰 삭제 로직
            reviewService.deleteReview(reviewId);
            return ResponseEntity.ok("리뷰 삭제 완료");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("리뷰 삭제 실패: " + e.getMessage());
        }
    }

}
