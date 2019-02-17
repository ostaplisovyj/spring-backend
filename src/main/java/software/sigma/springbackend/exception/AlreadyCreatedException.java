package software.sigma.springbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AlreadyCreatedException extends RuntimeException{
    public AlreadyCreatedException(String message) {
        super(message);
    }

    public AlreadyCreatedException(String message, Throwable cause) {
        super(message, cause);
    }
}
