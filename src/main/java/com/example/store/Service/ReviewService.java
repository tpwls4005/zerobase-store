package com.example.store.Service;

import com.example.store.Model.Review;
import com.example.store.Repository.ReviewRepository;
import com.example.store.dto.ReviewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public void writeReview(ReviewDTO reviewDTO) {
        Review review = new Review();
        review.setTitle(reviewDTO.getTitle());
        review.setContent(reviewDTO.getContent());
        review.setRating(reviewDTO.getRating());
        // 리뷰 엔티티 저장 로직
        reviewRepository.save(review);
    }

    public ReviewDTO getReviewById(Long reviewId) {
        Optional<Review> optionalReview = reviewRepository.findById(reviewId);
        if (optionalReview.isPresent()) {
            Review review = optionalReview.get();
            ReviewDTO reviewDTO = new ReviewDTO();
            reviewDTO.setId(review.getId());
            reviewDTO.setTitle(review.getTitle());
            reviewDTO.setContent(review.getContent());
            reviewDTO.setRating(review.getRating());
            return reviewDTO;
        } else {
            throw new RuntimeException("리뷰를 찾을 수 없습니다.");
        }
    }

    public List<ReviewDTO> getAllReviews() {
        List<Review> reviews = reviewRepository.findAll();
        // 리뷰 엔티티 리스트를 리뷰DTO 리스트로 변환하는 로직
        List<ReviewDTO> reviewDTOs = new ArrayList<>();
        for (Review review : reviews) {
            ReviewDTO reviewDTO = new ReviewDTO();
            reviewDTO.setId(review.getId());
            reviewDTO.setTitle(review.getTitle());
            reviewDTO.setContent(review.getContent());
            reviewDTO.setRating(review.getRating());
            reviewDTOs.add(reviewDTO);
        }
        return reviewDTOs;
    }

    public void updateReview(Long reviewId, ReviewDTO updatedReview) {
        Optional<Review> optionalReview = reviewRepository.findById(reviewId);
        if (optionalReview.isPresent()) {
            Review review = optionalReview.get();
            // 업데이트할 내용을 엔티티에 적용
            review.setTitle(updatedReview.getTitle());
            review.setContent(updatedReview.getContent());
            review.setRating(updatedReview.getRating());
            // 리뷰 엔티티 업데이트 로직
            reviewRepository.save(review);
        } else {
            throw new RuntimeException("리뷰를 찾을 수 없습니다.");
        }
    }

    public void deleteReview(Long reviewId) {
        // 리뷰 삭제 로직
        reviewRepository.deleteById(reviewId);
    }
}
