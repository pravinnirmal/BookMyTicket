package pnd.pravin.bookmyticket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pnd.pravin.bookmyticket.model.NowShowing;
import pnd.pravin.bookmyticket.repository.MoviesNowRepo;

import java.util.List;

@Service
public class NowShowingService {
    @Autowired
    private MoviesNowRepo moviesNowRepo;

    public NowShowing findShowById(String id){
        return moviesNowRepo.findById(id).orElse(new NowShowing("Name", "English0", "Ab", "WIIE#3"));

    }

    public List<NowShowing> findAllShows(){
        moviesNowRepo.save(new NowShowing("Name2", "English0", "Ab", "WI#3"));
        return (List<NowShowing>) moviesNowRepo.findAll();
    }


}
