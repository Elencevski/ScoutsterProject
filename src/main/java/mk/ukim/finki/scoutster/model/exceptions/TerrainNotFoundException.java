package mk.ukim.finki.scoutster.model.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class TerrainNotFoundException extends  RuntimeException{

    public TerrainNotFoundException(Long id)
    {
        super(String.format("Terrain with id %d was not found",id));
    }
}
