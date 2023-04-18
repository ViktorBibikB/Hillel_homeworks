package exceptions;

public class ProductDoesNotExistException extends Exception{
    public ProductDoesNotExistException(String message) {
        super(message);
    }
}