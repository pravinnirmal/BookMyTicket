package pnd.pravin.bookmyticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pnd.pravin.bookmyticket.model.Seats;

public interface SeatsRepo extends JpaRepository<Seats, Integer> {
    void deleteSeatsByShowId(Long showId);
}
