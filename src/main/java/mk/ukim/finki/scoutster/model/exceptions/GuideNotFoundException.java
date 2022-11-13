package mk.ukim.finki.scoutster.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class GuideNotFoundException extends RuntimeException {

    public GuideNotFoundException(Long id)
    {
        super(String.format("Guide with id %d was not found", id));
    }
}
