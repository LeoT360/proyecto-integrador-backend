package co.edu.cesde.ga.domain.exceptions;

public class UserConflictoException extends ResourceConflictoException {
    public UserConflictoException(String message) {
        super(message);
    }
}
