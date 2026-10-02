package co.edu.cesde.ga.domain.exceptions;

public class UserRoleNoEncontradoException extends ResourceNoEncontradoException {
    public UserRoleNoEncontradoException(Long id) {
        super("No se encontró userrole con id: " + id);
    }

    public UserRoleNoEncontradoException(String value) {
        super("No se encontró userrole: " + value);
    }
}
