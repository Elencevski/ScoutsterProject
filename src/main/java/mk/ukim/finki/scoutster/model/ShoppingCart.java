package mk.ukim.finki.scoutster.model;


import lombok.Data;
import mk.ukim.finki.scoutster.model.enumerations.ShoppingCartStatus;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private LocalDateTime dateCreated;

    @ManyToOne
    private User user;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Tour> tours;

    @Enumerated(EnumType.STRING)
    private ShoppingCartStatus status;



    public ShoppingCart() {
    }

    public ShoppingCart(User user) {
        this.dateCreated = LocalDateTime.now();
        this.user = user;
        this.tours = new ArrayList<>();
        this.status = ShoppingCartStatus.CREATED;
    }
}
