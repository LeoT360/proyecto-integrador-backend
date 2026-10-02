package co.edu.cesde.ga.domain.exceptions;

public class UserNoEncontradoException extends ResourceNoEncontradoException {
    public UserNoEncontradoException(Long id) {
        super("No se encontró user con id: " + id);
    }

    public UserNoEncontradoException(String value) {
        super("No se encontró user: " + value);
    }
}
