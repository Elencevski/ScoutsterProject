package mk.ukim.finki.scoutster.model.exceptions;

public class PasswordsDoNotMatchException extends RuntimeException{

    public PasswordsDoNotMatchException()  // nekoj konstruktor...
    {
        super("Password Do not match!");
    }
}
