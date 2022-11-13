package mk.ukim.finki.scoutster.service.impl;

import mk.ukim.finki.scoutster.model.User;
import mk.ukim.finki.scoutster.model.enumerations.Provider;
import mk.ukim.finki.scoutster.model.enumerations.Role;
import mk.ukim.finki.scoutster.model.exceptions.InvalidUsernameOrPasswordException;
import mk.ukim.finki.scoutster.model.exceptions.PasswordsDoNotMatchException;
import mk.ukim.finki.scoutster.model.exceptions.UsernameAlreadyExistsException;
import mk.ukim.finki.scoutster.repository.UserRepository;
import mk.ukim.finki.scoutster.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return (UserDetails) userRepository.findByUsername(s).orElseThrow(()->new UsernameNotFoundException(s));
    }


    @Override
    public User register(String username, String password, String repeatPassword, String name, String surname, Role role) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new InvalidUsernameOrPasswordException();
        }
        if (!password.equals(repeatPassword)) {
            throw new PasswordsDoNotMatchException();
        }
        if (this.userRepository.findByUsername(username).isPresent()) {
            throw new UsernameAlreadyExistsException(username);
        }
        User user = new User(name,surname,username,passwordEncoder.encode(password), role);
        return userRepository.save(user);
    }





    @Override
    public void processOAuthPostLogin(String username) {



        User existUser = userRepository.getUserByUsername(username);


            if (existUser == null) {
                User newUser = new User();
                newUser.setUsername(username);
                newUser.setProvider(Provider.FACEBOOK);
                newUser.setEnabled(true);

                userRepository.save(newUser);
            }

        }

    }

