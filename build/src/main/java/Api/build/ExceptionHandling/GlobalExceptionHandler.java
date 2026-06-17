package Api.build.ExceptionHandling;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
    

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse>handleNotFound(ResourceNotFoundException ex)
    {
        ErrorResponse error= new ErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), ex.getMessage());

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse>handleException(Exception ex)
    {
        ErrorResponse error = new ErrorResponse(LocalDateTime.now(),
                                                    HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());


        return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(InvalidCredentialException.class)
    public ResponseEntity<ErrorResponse>handleLogin(InvalidCredentialException ex)
    {
        ErrorResponse error=new ErrorResponse(LocalDateTime.now(),HttpStatus.UNAUTHORIZED.value(), "Inavlid Credentials");


        System.out.println("Invalid Credentials");
        return new ResponseEntity<>(error,HttpStatus.UNAUTHORIZED);
    }


    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorResponse>handleLogin(BadCredentialsException ex)
    {
        ErrorResponse error=new ErrorResponse(LocalDateTime.now(),HttpStatus.UNAUTHORIZED.value(), "Inavlid Credentials");


        System.out.println("Invalid Credentials");
        return new ResponseEntity<>(error,HttpStatus.UNAUTHORIZED);
    }


}
