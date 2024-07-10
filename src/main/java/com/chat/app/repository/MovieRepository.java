package com.chat.app.repository;

import com.chat.app.entity.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId>
{

    @Query("{'imdbId' : ?0 }")
    Optional<Movie> findByImdbId(String imdbId);
}
