package pnd.pravin.bookmyticket.repository;

import org.springframework.data.jpa.repository.Query;
import pnd.pravin.bookmyticket.dto.response.AvailableSeats;
import pnd.pravin.bookmyticket.dto.response.SeatTotal;
import pnd.pravin.bookmyticket.dto.response.SeatsResponse;
import pnd.pravin.bookmyticket.model.Seats;

import java.util.ArrayList;
import java.util.List;

public abstract class SeatsRepoImpl implements SeatsRepo {

    @Override
    @Query("DELETE Seats s WHERE s.showId= ?1")
    public void deleteSeatsByShowId(Long showId) {}

    @Override
    @Query("select s from Seats s where s.showId= ?1 and s.isBooked=false")
    public List<AvailableSeats> getSeatsByShowId(Long showId) {
        return null;
    }

//    @Override
//    @Query("SELECT COUNT(s) FROM Seats s WHERE s.showId= ?1 AND s.isBooked=FALSE")
//    public Long countAvailableSeatsByShowId(Long showId) {
//        return null;
//    }

}
