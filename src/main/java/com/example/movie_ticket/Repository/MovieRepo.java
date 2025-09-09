package com.example.movie_ticket.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.movie_ticket.Model.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Long>{

}
