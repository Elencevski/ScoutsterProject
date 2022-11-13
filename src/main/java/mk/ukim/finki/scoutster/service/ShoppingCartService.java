package mk.ukim.finki.scoutster.service;

import mk.ukim.finki.scoutster.model.ShoppingCart;
import mk.ukim.finki.scoutster.model.Tour;

import java.util.List;

public interface ShoppingCartService {

    List<Tour> listAllToursInShoppingCart (Long id);

    ShoppingCart getActiveShoppingCart(String username);

    ShoppingCart addTourInShoppingCart(String username, Long tourId);   //dali go znae tourID


}
