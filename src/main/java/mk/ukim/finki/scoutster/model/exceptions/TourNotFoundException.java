package mk.ukim.finki.scoutster.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TourNotFoundException extends  RuntimeException{

    public TourNotFoundException(Long id) {
        super(String.format("Tour with id %d was not found", id));
    }
}
