package pnd.pravin.bookmyticket.dto.response;

import lombok.Builder;

@Builder
public record MoviesResponse(Long id, String movieName, String startTime, String language) {
}
