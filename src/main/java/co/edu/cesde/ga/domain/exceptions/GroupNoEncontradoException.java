package co.edu.cesde.ga.domain.exceptions;

public class GroupNoEncontradoException extends ResourceNoEncontradoException {
    public GroupNoEncontradoException(Long id) {
        super("No se encontró group con id: " + id);
    }

    public GroupNoEncontradoException(String value) {
        super("No se encontró group: " + value);
    }
}
