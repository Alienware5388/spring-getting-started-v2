package ro.sda.spring.exception;

public class ProductAppException extends RuntimeException {
    public ProductAppException(String message) {
        super(message);
    }
}
