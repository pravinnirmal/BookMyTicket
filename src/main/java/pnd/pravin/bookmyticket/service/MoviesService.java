package pnd.pravin.bookmyticket.service;

import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import pnd.pravin.bookmyticket.dto.request.MoviesRequest;
import pnd.pravin.bookmyticket.dto.response.MoviesResponse;
import pnd.pravin.bookmyticket.exception.MovieNotFoundException;
import pnd.pravin.bookmyticket.model.Movies;
import pnd.pravin.bookmyticket.repository.MoviesRepo;
import pnd.pravin.bookmyticket.repository.SeatsRepo;

import java.util.List;
import java.util.Map;

@Service
public class MoviesService {

    private final MoviesRepo moviesRepo;

    private final SeatsService seatsService;

    MoviesService (MoviesRepo moviesNowRepo, SeatsService seatsService) {
        this.moviesRepo = moviesNowRepo;
        this.seatsService = seatsService;
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

    @Transactional
    public void addMovie(@Valid MoviesRequest moviesRequest) {
        try {
            for (Map.Entry<String, String> entry : moviesRequest.shows().entrySet()) {
               Movies savedMovie =  moviesRepo.save(Movies.builder()
                        .movieName(moviesRequest.movieName())
                        .startTime(entry.getKey())
                        .language(entry.getValue()).build());
               Long showId = savedMovie.getId();
               seatsService.addSeatsForNewShow(showId);
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
