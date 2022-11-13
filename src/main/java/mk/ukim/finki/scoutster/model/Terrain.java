package mk.ukim.finki.scoutster.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Terrain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(length = 4000)
    private String description;

    public Terrain() {

    }

    public Terrain(String name, String description) {


        this.name = name;
        this.description = description;
    }

}
