package pnd.pravin.bookmyticket.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "seats")
public class Seats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Long showId;
    private String seatNumber;
    @Column(columnDefinition = "boolean default false")
    private boolean isBooked;
    private int version;
}
