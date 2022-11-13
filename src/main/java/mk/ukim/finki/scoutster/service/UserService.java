package mk.ukim.finki.scoutster.service;

import mk.ukim.finki.scoutster.model.User;
import mk.ukim.finki.scoutster.model.enumerations.Role;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User register(String username, String password, String repeatPassword,
                  String name, String surname, Role role);

    void processOAuthPostLogin(String username);


}
