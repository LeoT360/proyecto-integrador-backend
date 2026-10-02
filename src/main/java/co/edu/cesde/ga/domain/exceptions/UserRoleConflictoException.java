package co.edu.cesde.ga.domain.exceptions;

public class UserRoleConflictoException extends ResourceConflictoException {
    public UserRoleConflictoException(String message) {
        super(message);
    }
}
