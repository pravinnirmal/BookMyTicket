package pnd.pravin.bookmyticket.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pnd.pravin.bookmyticket.model.NowShowing;


@Repository
public interface MoviesNowRepo extends CrudRepository<NowShowing, String> {

}
