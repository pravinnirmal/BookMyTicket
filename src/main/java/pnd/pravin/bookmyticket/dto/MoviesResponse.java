package pnd.pravin.bookmyticket.dto;

import lombok.Builder;

@Builder
public record MoviesResponse(Long id, String movieName, String startTime) {
}
