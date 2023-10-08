package com.example.store.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
public class ReviewDTO {
    @Setter
    private Long id;
    private String title;
    private String content;
    private int rating;

    // 생성자
    public ReviewDTO() {
    }

    public ReviewDTO(Long id, String title, String content, int rating) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.rating = rating;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    // toString() 메서드 (디버깅 및 로깅 용도)
    @Override
    public String toString() {
        return "ReviewDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", rating=" + rating +
                '}';
    }
}
