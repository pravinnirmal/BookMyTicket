package pnd.pravin.bookmyticket.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Map;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "movies")
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String movieName;
    private String startTime;
    private String language;
    @Transient
    private Map<String, String> shows;
}
