package com.example.movie_ticket.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.movie_ticket.Repository.MovieRepo;
import com.example.movie_ticket.Exception.ResourceNotFoundException;
import com.example.movie_ticket.Model.Movie;

@Service
public class MovieServiceImpl implements MovieService{


    private final MovieRepo movieRepo;
    public MovieServiceImpl(MovieRepo movieRepo){   //Setter Injection
        this.movieRepo = movieRepo;
    }
    
    @Override
    public List<Movie> getAllMovies(){
        return movieRepo.findAll();
    }

    @Override
    public Movie getMovieById(Long id){
        return movieRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Movie found with this id : " + id ));
    }
    
    @Override
    public Movie saveMovie(Movie movie){
        return movieRepo.save(movie);
    }

    @Override
    public void deleteMovie(Long id){
        movieRepo.deleteById(id);
    }

}
