package pl.sytomczak.supplementstore.mappings;

import javax.persistence.*;

@Entity
@Table(name = "zeroCalories")
public class ZeroCalories {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
