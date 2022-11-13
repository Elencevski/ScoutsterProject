package mk.ukim.finki.scoutster.service;

import mk.ukim.finki.scoutster.model.User;

public interface AuthService {

    User login(String username, String password);

}
