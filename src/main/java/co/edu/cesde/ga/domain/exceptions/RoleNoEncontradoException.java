package co.edu.cesde.ga.domain.exceptions;

public class RoleNoEncontradoException extends ResourceNoEncontradoException {
    public RoleNoEncontradoException(Long id) {
        super("No se encontró role con id: " + id);
    }

    public RoleNoEncontradoException(String value) {
        super("No se encontró role: " + value);
    }
}
