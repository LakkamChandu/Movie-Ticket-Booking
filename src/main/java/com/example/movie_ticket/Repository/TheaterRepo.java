package com.example.movie_ticket.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.movie_ticket.Model.Theater;

@Repository
public interface TheaterRepo extends JpaRepository<Theater, Long>{
    
}
