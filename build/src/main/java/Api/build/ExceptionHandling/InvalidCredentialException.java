package Api.build.ExceptionHandling;

public class InvalidCredentialException extends RuntimeException {

    public InvalidCredentialException(String message)
    {
        super(message);
    }
    
}
