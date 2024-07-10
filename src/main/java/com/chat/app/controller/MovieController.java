package com.chat.app.controller;

import com.chat.app.entity.Movie;
import com.chat.app.service.MovieService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/movies")
public class MovieController
{
    private final MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> allMovies()
    {
        List<Movie> response = movieService.allMovies();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Movie> getMovie(@PathVariable("imdbId") String imdbId)
    {
        Movie response = movieService.getMovie(imdbId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
