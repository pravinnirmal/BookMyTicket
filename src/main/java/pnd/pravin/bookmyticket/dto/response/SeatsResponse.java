package pnd.pravin.bookmyticket.dto.response;

import lombok.Builder;

import java.util.List;

@Builder
public record SeatsResponse(SeatTotal seatTotal, List <AvailableSeats> availableSeats) {
}
