package com.example.movie_ticket.Service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.movie_ticket.Exception.ResourceNotFoundException;
import com.example.movie_ticket.Model.Theater;
import com.example.movie_ticket.Repository.TheaterRepo;

@Service
public class TheaterServiceImpl implements TheaterService{

    private final TheaterRepo theaterRepo;
    public TheaterServiceImpl(TheaterRepo theaterRepo){
        this.theaterRepo = theaterRepo;
    }

    @Override
    public List<Theater> getAllTheaters(){
        return theaterRepo.findAll();
    }
    
    @Override
    public Theater getTheaterById(Long id){
        return theaterRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Theater Found with this id : " + id ));
    }

    @Override
    public Theater saveTheater(Theater theater){
        return theaterRepo.save(theater);
    }

    @Override
    public void deleteTheater(Long id){
        theaterRepo.deleteById(id);
    }

}
