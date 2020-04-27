package pl.sytomczak.app.mappings;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "rentals")

public class Rental {

    @Id
    @Getter
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Setter
    @OneToOne
    private Book book;
    @Setter
    @OneToOne
    private Reader reader;
    @Setter
    private LocalDateTime rentalDate;

}
