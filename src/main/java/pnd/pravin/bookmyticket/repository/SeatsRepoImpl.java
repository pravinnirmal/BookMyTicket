package pnd.pravin.bookmyticket.repository;

import org.springframework.data.jpa.repository.Query;

public abstract class SeatsRepoImpl implements SeatsRepo {

    @Override
    @Query("DELETE Seats s WHERE s.showId= ?1")
    public void deleteSeatsByShowId(Long showId) {

    }
}
