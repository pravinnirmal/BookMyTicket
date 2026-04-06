package pnd.pravin.bookmyticket.service;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import pnd.pravin.bookmyticket.dto.MoviesRequest;
import pnd.pravin.bookmyticket.dto.MoviesResponse;
import pnd.pravin.bookmyticket.exception.MovieNotFoundException;
import pnd.pravin.bookmyticket.model.Movies;
import pnd.pravin.bookmyticket.repository.MoviesRepo;

import java.util.List;
import java.util.Map;

@Service
public class MoviesService {

    MoviesRepo moviesRepo;

    MoviesService (MoviesRepo moviesNowRepo) {
        this.moviesRepo = moviesNowRepo;
    }

    public List<MoviesResponse> getAllMovies() {
       return moviesRepo.findAll().stream()
               .map(movies -> new MoviesResponse(
                       movies.getId(),
                       movies.getMovieName(),
                       movies.getStartTime(),
                       movies.getLanguage()
               )).toList();
    }

    public void addMovie(@Valid MoviesRequest moviesRequest) {
        try {
            for (Map.Entry<String, String> entry : moviesRequest.shows().entrySet()) {
                moviesRepo.save(Movies.builder()
                        .movieName(moviesRequest.movieName())
                        .startTime(entry.getKey())
                        .language(entry.getValue()).build());
            }
        } catch (Exception e) {
            throw new RuntimeException("Error while adding movie", e);
        }
    }

    public void deleteMovie(@Valid int id){
        if(!moviesRepo.existsById(id)){
                        throw new MovieNotFoundException("Unable to find movie with id " + id);
        }
           moviesRepo.deleteById(id);

    }
}
