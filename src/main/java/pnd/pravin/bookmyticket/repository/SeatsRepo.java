package pnd.pravin.bookmyticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pnd.pravin.bookmyticket.dto.response.AvailableSeats;
import pnd.pravin.bookmyticket.model.Seats;

import java.util.List;

public interface SeatsRepo extends JpaRepository<Seats, Integer> {
    void deleteSeatsByShowId(Long showId);
    long countByShowIdAndIsBookedFalse(Long showId);
    List<AvailableSeats> getAvailableSeatsByShowIdAndIsBookedFalse(Long showId);
}
