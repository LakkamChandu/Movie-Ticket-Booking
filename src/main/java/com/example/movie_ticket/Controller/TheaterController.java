package com.example.movie_ticket.Controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.movie_ticket.Model.Theater;
import com.example.movie_ticket.Service.TheaterService;

@RestController
@RequestMapping("/api/theaters")
public class TheaterController {

    private final TheaterService theaterService;
    public TheaterController(TheaterService theaterService){
        this.theaterService = theaterService;
    }

    @GetMapping
    public List<Theater> getAllTheaters(){
        return theaterService.getAllTheaters();
    }

    @GetMapping("/{theaterId}")
    public Theater getTheaterById(@PathVariable Long theaterId){
        return theaterService.getTheaterById(theaterId);
    }

    @PostMapping
    public Theater saveTheater(@RequestBody Theater theater){
        return theaterService.saveTheater(theater);
    }

    @DeleteMapping("/{theaterId}")
    public void deleteTheater(Long theaterId){
        theaterService.deleteTheater(theaterId);
    }
}
