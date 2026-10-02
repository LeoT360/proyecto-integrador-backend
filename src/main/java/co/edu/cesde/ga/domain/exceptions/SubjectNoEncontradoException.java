package co.edu.cesde.ga.domain.exceptions;

public class SubjectNoEncontradoException extends ResourceNoEncontradoException {
    public SubjectNoEncontradoException(Long id) {
        super("No se encontró subject con id: " + id);
    }

    public SubjectNoEncontradoException(String value) {
        super("No se encontró subject: " + value);
    }
}
