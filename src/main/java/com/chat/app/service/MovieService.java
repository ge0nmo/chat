package com.chat.app.service;

import com.chat.app.entity.Movie;
import com.chat.app.entity.Review;
import com.chat.app.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MovieService
{
    private final MovieRepository movieRepository;

    public List<Movie> allMovies()
    {
        return movieRepository.findAll();
    }

    public Movie getMovie(String imdbId)
    {
        return movieRepository.findByImdbId(imdbId).orElse(null);
    }

    public void addReview(String idbmId, Review review)
    {
        Movie movie = getMovie(idbmId);
        if(movie.getReviews() == null)
            movie.setReviews(new ArrayList<Review>());

        movie.getReviews().add(review);

        movieRepository.save(movie);
    }
}
