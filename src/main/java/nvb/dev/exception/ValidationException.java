package nvb.dev.exception;

public class ValidationException extends IllegalArgumentException {

    public ValidationException() {
    }

    public ValidationException(String s) {
        super(s);
    }
}
