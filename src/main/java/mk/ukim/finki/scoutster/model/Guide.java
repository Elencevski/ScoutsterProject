package mk.ukim.finki.scoutster.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "guides")
public class Guide {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;


    public Guide() {

    }

    public Guide(String name, String surname) {


        this.name = name;
        this.surname = surname;
    }
}
