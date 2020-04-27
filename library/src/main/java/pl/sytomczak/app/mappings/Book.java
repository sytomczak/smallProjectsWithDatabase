package pl.sytomczak.app.mappings;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "books")
@NamedQueries({
        @NamedQuery(name = "getAllBooks", query = "from Book b"),
        @NamedQuery(name = "getBookById", query = "from Book b where b.id=:id"),
        @NamedQuery(name = "getBookByName", query = "from Book b where b.name=:name")
})
public class Book {

    @Id
    @Getter
    @Column(name = "id")
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;

    @Getter
    @Setter
    private String name;



    public Book() {
    }
}