package ro.sda.spring.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ro.sda.spring.exception.model.ClientError;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(value = ProductAppException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ClientError handleProductAppException(ProductAppException ex){
        log.warn("An exception occurred with message: {}", ex.getMessage());
        return new ClientError(LocalDateTime.now(), ex.getMessage(), HttpStatus.NOT_FOUND.value());
    }

}
