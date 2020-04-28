package pl.sytomczak.library2.mappings;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "books")

public class Book {

    @Id
    @Getter
    @Column(name = "id")
    @GeneratedValue
    private int id;

    @Getter
    @Setter
    @Column(name = "name")
    private String name;

}
