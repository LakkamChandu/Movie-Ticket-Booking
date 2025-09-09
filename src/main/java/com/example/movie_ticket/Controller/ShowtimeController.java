package com.example.movie_ticket.Controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.movie_ticket.Model.Showtime;
import com.example.movie_ticket.Service.ShowtimeService;

@RestController
@RequestMapping("/api/showtimes")
public class ShowtimeController {

    private final ShowtimeService showtimeService;
    public ShowtimeController(ShowtimeService showtimeService){
        this.showtimeService = showtimeService;
    }

    @GetMapping
    public List<Showtime> getAllShowtimes(){
        return showtimeService.getAllShowTimes();
    }

    @GetMapping("/{showtimeId}")
    public Showtime getShowtimeById(@PathVariable Long showtimeId){
        return showtimeService.getShowtimeById(showtimeId);
    }

    @PostMapping
    public Showtime saveShowtime(@RequestBody Showtime showtime){
        return showtimeService.saveShowTime(showtime);
    }

    @DeleteMapping("/{showtimeId}")
    public void deleteShowTime(@PathVariable Long showtimeId){
        showtimeService.deleteShowTime(showtimeId);
    }

    @GetMapping("/movie/{movieId}")
    public List<Showtime> getShowtimesByMovie(@PathVariable Long movieId){
        return showtimeService.getShowtimesByMovie(movieId);
    }

    @GetMapping("/theater/{theaterId}")
    public List<Showtime> getShowtimesByTheater(@PathVariable Long theaterId){
        return showtimeService.getShowtimesByTheater(theaterId);
    }
    
}
