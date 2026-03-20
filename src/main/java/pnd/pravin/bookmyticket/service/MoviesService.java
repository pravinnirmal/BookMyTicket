package pnd.pravin.bookmyticket.service;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import pnd.pravin.bookmyticket.dto.MoviesRequest;
import pnd.pravin.bookmyticket.dto.MoviesResponse;
import pnd.pravin.bookmyticket.model.Movies;
import pnd.pravin.bookmyticket.repository.MoviesRepo;

import java.util.List;
import java.util.stream.Stream;

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

    public boolean addMovie(@Valid MoviesRequest moviesRequest) {
         moviesRepo.save(Movies.builder()
                .movieName(moviesRequest.movieName())
                .startTime(moviesRequest.startTime())
                 .language(moviesRequest.language()).build());

        return true;
    }
}
