package pl.sytomczak.app.mappings;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "readers")
@NamedQueries({
        @NamedQuery(name = "getAllReaders", query = "from Reader r"),
        @NamedQuery(name = "getReaderById", query = "from Reader r where r.id=:id"),
        @NamedQuery(name = "getReaderByName", query = "from Reader r where r.name=:name"),
        @NamedQuery(name = "getReaderBySurname", query = "from Reader r where r.surname=:surname")

})
public class Reader {

    @Id
    @Getter
    @Column(name = "id")
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    @Column(name = "surname")
    private String surname;

    public Reader() {
    }
}

