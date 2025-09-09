package com.example.movie_ticket.Service;

import java.util.List;
import com.example.movie_ticket.Model.Theater;

public interface TheaterService {

    List<Theater> getAllTheaters();

    Theater getTheaterById(Long id);

    Theater saveTheater(Theater theater);
    
    void deleteTheater(Long id);

}
