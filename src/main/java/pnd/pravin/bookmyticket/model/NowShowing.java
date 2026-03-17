package pnd.pravin.bookmyticket.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "now_showing", schema = "movies_now")
public class NowShowing {

    @Column(name = "movie_name")
    private String movieName;
    @Column(name = "language")
    private String language;
    @Column(name = "slots")
    private String slots;
    @Id
    @Column(name = "id")
    private String id;

}
