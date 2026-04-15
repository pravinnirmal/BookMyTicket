package pnd.pravin.bookmyticket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pnd.pravin.bookmyticket.dto.response.AvailableSeats;
import pnd.pravin.bookmyticket.dto.response.SeatTotal;
import pnd.pravin.bookmyticket.dto.response.SeatsResponse;
import pnd.pravin.bookmyticket.model.Seats;
import pnd.pravin.bookmyticket.repository.SeatsRepo;
import pnd.pravin.bookmyticket.util.SeatConstants;

import java.util.List;

@Service
public class SeatsService {

    @Autowired
    private SeatsRepo seatsRepo;

    public void addSeatsForNewShow(Long showId) {
        for (String row : SeatConstants.ROW) {
            for (int i = 0; i < SeatConstants.SEATS; i++) {
                Seats seat = Seats.builder()
                        .seatNumber(row + i)
                        .showId(showId)
                        .version(1)
                        .build();
                seatsRepo.save(seat);
            }
        }
    }

        public void deleteSeatsForDeletedShow(Long showId) {
            seatsRepo.deleteSeatsByShowId(showId);
        }

        public SeatsResponse getSeatsForShow(Long showId) {
            List <AvailableSeats> availableSeats= seatsRepo.getAvailableSeatsByShowIdAndIsBookedFalse(showId);
            SeatTotal seatTotalCount = SeatTotal.builder()
                    .totalSeats(seatsRepo.countByShowIdAndIsBookedFalse(showId))
                    .build();

            return SeatsResponse.builder()
                    .availableSeats(availableSeats)
                    .seatTotal(seatTotalCount)
                    .build();
        }


}
