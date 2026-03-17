package pnd.pravin.bookmyticket.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pnd.pravin.bookmyticket.model.NowShowing;
import pnd.pravin.bookmyticket.service.NowShowingService;

import java.util.List;

@RestController
public class HelloController {


    private final NowShowingService nowShowingService;

    public HelloController(NowShowingService nowShowingService) {
        this.nowShowingService = nowShowingService;
    }


    @GetMapping
    public String hello() {
        return "hello";
    }

    @GetMapping("/get")
    public NowShowing hello2() {
        return nowShowingService.findShowById("E234");
    }

    @GetMapping(value ="/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<NowShowing> findAll() {
        return nowShowingService.findAllShows();
    }
}
