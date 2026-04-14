package pnd.pravin.bookmyticket.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pnd.pravin.bookmyticket.dto.response.SeatsResponse;
import pnd.pravin.bookmyticket.repository.SeatsRepo;
import pnd.pravin.bookmyticket.repository.SeatsRepoImpl;
import pnd.pravin.bookmyticket.service.SeatsService;

import java.util.List;

@RestController
@RequestMapping("api/v1/booking")
public class BookingController {

    private final SeatsRepo seatsRepo;
    private final SeatsService seatsService;

    public BookingController(SeatsRepo seatsRepo, SeatsService seatsService) {
        this.seatsRepo = seatsRepo;
        this.seatsService = seatsService;
    }

    @GetMapping({"/show/{id}"})
    public ResponseEntity <SeatsResponse> getSeatsByShow(@Valid @PathVariable Long id) {
        SeatsResponse result = seatsService.getSeatsForShow(id);
//        if (result.) {
//            return ResponseEntity.noContent().build();
//        }
        return ResponseEntity.ok(result);
    }

}
