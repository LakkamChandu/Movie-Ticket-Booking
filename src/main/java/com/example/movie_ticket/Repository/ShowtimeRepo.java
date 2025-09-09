package com.example.movie_ticket.Repository;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.movie_ticket.Model.Showtime;

@Repository
public interface ShowtimeRepo extends JpaRepository<Showtime,Long>{

    public List<Showtime> findByMovieId(Long theaterId);

    public List<Showtime> findByTheaterId(Long theaterId);

    public List<Showtime> findByShowDateTimeBetween(LocalDateTime start, LocalDateTime end);
    
}
