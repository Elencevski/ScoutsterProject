package mk.ukim.finki.scoutster.service.impl;

import mk.ukim.finki.scoutster.model.ShoppingCart;
import mk.ukim.finki.scoutster.model.Tour;
import mk.ukim.finki.scoutster.model.User;
import mk.ukim.finki.scoutster.model.enumerations.ShoppingCartStatus;
import mk.ukim.finki.scoutster.model.exceptions.ShoppingCartNotFoundException;
import mk.ukim.finki.scoutster.model.exceptions.TourAlreadyInShoppingCart;
import mk.ukim.finki.scoutster.model.exceptions.TourNotFoundException;
import mk.ukim.finki.scoutster.model.exceptions.UserNotFoundException;
import mk.ukim.finki.scoutster.repository.ShoppingCartRepository;
import mk.ukim.finki.scoutster.repository.UserRepository;
import mk.ukim.finki.scoutster.service.ShoppingCartService;
import mk.ukim.finki.scoutster.service.TourService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

private final ShoppingCartRepository shoppingCartRepository;
private final UserRepository userRepository;
private final TourService tourService;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository, UserRepository userRepository, TourService tourService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.userRepository = userRepository;
        this.tourService = tourService;
    }


    @Override
    public List<Tour> listAllToursInShoppingCart(Long cartId) {
        if(!this.shoppingCartRepository.findById(cartId).isPresent())

            throw new ShoppingCartNotFoundException(cartId);

        return this.shoppingCartRepository.findById(cartId).get().getTours();
    }

    @Override
    public ShoppingCart getActiveShoppingCart(String username) {
        User user = this.userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(username));

        return this.shoppingCartRepository
                .findByUserAndStatus(user, ShoppingCartStatus.CREATED)
                .orElseGet(() -> {
                    ShoppingCart cart = new ShoppingCart(user);
                    return this.shoppingCartRepository.save(cart);
                });
    }

    @Override
    public ShoppingCart addTourInShoppingCart(String username, Long tourId) {
        ShoppingCart shoppingCart = this.getActiveShoppingCart(username);
        Tour tour = this.tourService.findById(tourId).orElseThrow(()-> new TourNotFoundException(tourId));

        if(shoppingCart.getTours().stream().filter(i -> i.getId().equals(tourId)).collect(Collectors.toList()).size() > 0)
            throw new TourAlreadyInShoppingCart(tourId,username);  // da ne dozvolam duplikat

        shoppingCart.getTours().add(tour);

        return this.shoppingCartRepository.save(shoppingCart);
    }
}
