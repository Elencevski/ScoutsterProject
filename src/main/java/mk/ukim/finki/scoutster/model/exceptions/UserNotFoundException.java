package mk.ukim.finki.scoutster.model.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends  RuntimeException{

    public UserNotFoundException(String username) {
        super(String.format("Username with name %s was not found", username));
    }
}
