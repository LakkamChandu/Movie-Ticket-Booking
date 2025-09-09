package com.example.movie_ticket.Service;

import java.util.List;
import com.example.movie_ticket.Model.Showtime;


public interface ShowtimeService {

    List<Showtime> getAllShowTimes();

    Showtime getShowtimeById(Long id);

    Showtime saveShowTime(Showtime showtime);

    void deleteShowTime(Long id);

    List<Showtime> getShowtimesByTheater(Long theaterId);

    List<Showtime> getShowtimesByMovie(Long movieId);

}
