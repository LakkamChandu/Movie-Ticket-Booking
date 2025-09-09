package com.example.movie_ticket.Service;

import com.example.movie_ticket.Repository.ShowtimeRepo;
import java.util.List;
import org.springframework.stereotype.Service;

import com.example.movie_ticket.Exception.ResourceNotFoundException;
import com.example.movie_ticket.Model.Showtime;

@Service
public class ShowtimeServiceImpl implements ShowtimeService{

    private final ShowtimeRepo showtimeRepo;
    public ShowtimeServiceImpl(ShowtimeRepo showtimeRepo){
        this.showtimeRepo = showtimeRepo;
    }

    @Override
    public List<Showtime> getAllShowTimes(){
        return showtimeRepo.findAll();
    }

    @Override
    public Showtime getShowtimeById(Long id){
        return showtimeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Showtime Found with this id : " + id));
    }

    @Override
    public Showtime saveShowTime(Showtime showTime){
        return showtimeRepo.save(showTime);
    }

    @Override
    public void deleteShowTime(Long id){
        showtimeRepo.deleteById(id);
    }

    @Override
    public List<Showtime> getShowtimesByMovie(Long movieId){
        return showtimeRepo.findByMovieId(movieId);
    }

    @Override
    public List<Showtime> getShowtimesByTheater(Long theaterId){
        return showtimeRepo.findByTheaterId(theaterId);
    } 

}
