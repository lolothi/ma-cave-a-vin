package macaveavin.app.api.repository;

public class CellarPlaceNotEmptyException extends RuntimeException {
    public CellarPlaceNotEmptyException(String message) {
        super(message);
    }
}
