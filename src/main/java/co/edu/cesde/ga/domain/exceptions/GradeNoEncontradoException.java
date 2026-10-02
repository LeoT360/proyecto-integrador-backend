package co.edu.cesde.ga.domain.exceptions;

public class GradeNoEncontradoException extends ResourceNoEncontradoException {
    public GradeNoEncontradoException(Long id) {
        super("No se encontró grade con id: " + id);
    }

    public GradeNoEncontradoException(String value) {
        super("No se encontró grade: " + value);
    }
}
