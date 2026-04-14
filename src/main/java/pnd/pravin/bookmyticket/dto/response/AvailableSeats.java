package pnd.pravin.bookmyticket.dto.response;

import lombok.Builder;

@Builder
public record AvailableSeats(Long showId, int version, String seatNumber, Boolean isBooked) {
}
