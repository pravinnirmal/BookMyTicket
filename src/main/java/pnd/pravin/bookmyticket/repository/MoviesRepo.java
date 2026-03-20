package pnd.pravin.bookmyticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pnd.pravin.bookmyticket.model.Movies;

public interface MoviesRepo extends JpaRepository<Movies, Integer> {
}
