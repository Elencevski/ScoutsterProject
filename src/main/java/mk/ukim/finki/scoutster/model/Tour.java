package mk.ukim.finki.scoutster.model;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private Double price;

    private Integer persons;

    @ManyToOne
    private Terrain terrain;

    private String condition;

    @ManyToOne  // kako bazi
    private Guide guide;

    public Tour() {
    }

    public Tour(String name, Double price, Integer persons, Terrain terrain, Guide guide, String condition) {
        this.name = name;
        this.price = price;
        this.persons = persons;
        this.terrain = terrain;
        this.guide = guide;
        this.condition = condition;
    }
}
