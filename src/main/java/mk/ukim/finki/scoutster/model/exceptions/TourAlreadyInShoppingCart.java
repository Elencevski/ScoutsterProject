package mk.ukim.finki.scoutster.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
public class TourAlreadyInShoppingCart extends  RuntimeException{

    public TourAlreadyInShoppingCart(Long id, String username) {
        super(String.format("Product  with id: %d already exists in shopping cart, for user with username %s", id, username));
    }
}
