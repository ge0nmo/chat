package com.chat.app.controller;

import com.chat.app.dto.ReviewCreateRequest;
import com.chat.app.entity.Review;
import com.chat.app.service.ReviewService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/api/v1/reviews")
@RestController
public class ReviewController
{
    private final ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody ReviewCreateRequest request)
    {
        Review review = reviewService.createReview(request);

        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReview(@PathVariable("id") ObjectId id)
    {
        Review review = reviewService.findReviewById(id);

        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }


}
