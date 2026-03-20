package pnd.pravin.bookmyticket.dto;

import lombok.Builder;

@Builder
public record MoviesRequest(String movieName, String startTime) {

}
