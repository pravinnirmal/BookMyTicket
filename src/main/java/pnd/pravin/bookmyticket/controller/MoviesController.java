package pnd.pravin.bookmyticket.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pnd.pravin.bookmyticket.dto.MoviesRequest;
import pnd.pravin.bookmyticket.dto.MoviesResponse;
import pnd.pravin.bookmyticket.model.Movies;
import pnd.pravin.bookmyticket.service.MoviesService;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("api/v1/movies")
public class MoviesController {

    MoviesService moviesService;

    MoviesController(MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    @GetMapping()
    public ResponseEntity<List<MoviesResponse>> getMovies(){
            List <MoviesResponse> result = moviesService.getAllMovies();

            if (result.isEmpty()){
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(result);
    }

    @PostMapping("/addMovie")
    public ResponseEntity<MoviesRequest> addMovie(@Valid @RequestBody MoviesRequest moviesRequest){
       if (moviesService.addMovie(moviesRequest)) {
           return ResponseEntity.ok(moviesRequest);
       }
       return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
