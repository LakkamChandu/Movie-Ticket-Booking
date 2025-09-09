package com.example.movie_ticket.Exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    public ResponseEntity<Object> handleResourceNotFound(ResourceNotFoundException e, WebRequest request){
        Map<String,Object> body = new HashMap<>();
        body.put( "timestamp", LocalDateTime.now() );
        body.put( "status", HttpStatus.NOT_FOUND.value() );
        body.put( "error", "Not Found" );
        body.put( "message", e.getMessage());
        body.put( "path", request.getDescription(false));
        return new ResponseEntity<>(body,HttpStatus.NOT_FOUND);
        
    }

    // public ResponseEntity<Object> handleBadRequest(BadRequestException e, WebRequest request){
    //     return 
    // }

}
