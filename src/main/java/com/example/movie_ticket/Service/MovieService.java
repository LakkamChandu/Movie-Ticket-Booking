package com.example.movie_ticket.Service;

import java.util.List;
import com.example.movie_ticket.Model.Movie;


public interface MovieService {

    List<Movie> getAllMovies();

    Movie getMovieById(Long id);

    Movie saveMovie(Movie movie);

    void deleteMovie(Long id);
    
}
