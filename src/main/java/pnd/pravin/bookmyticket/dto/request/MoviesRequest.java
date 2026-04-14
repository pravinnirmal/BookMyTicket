package pnd.pravin.bookmyticket.dto.request;

import lombok.Builder;

import java.util.Map;

@Builder
public record MoviesRequest(String movieName, Map<String, String> shows, String language) {

}
