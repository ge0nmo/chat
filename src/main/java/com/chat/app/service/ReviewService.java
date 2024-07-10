package com.chat.app.service;

import com.chat.app.dto.ReviewCreateRequest;
import com.chat.app.entity.Review;
import com.chat.app.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReviewService
{
    private final ReviewRepository reviewRepository;
    private final MovieService movieService;

    public Review createReview(ReviewCreateRequest request)
    {
        Review review = new Review();
        review.setBody(request.getBody());

        Review savedreview = reviewRepository.insert(review);

        movieService.addReview(request.getImdbId(), savedreview);

        return savedreview;
    }

    public Review findReviewById(ObjectId id)
    {
        return reviewRepository.findById(id).orElse(null);
    }


    public boolean remove(ObjectId id){
        Review review = findReviewById(id);

        reviewRepository.delete(review);

        return reviewRepository.existsById(id);
    }
}
