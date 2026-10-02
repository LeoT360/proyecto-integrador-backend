package co.edu.cesde.ga.domain.exceptions;

public class EnrollmentNoEncontradoException extends ResourceNoEncontradoException {
    public EnrollmentNoEncontradoException(Long id) {
        super("No se encontró enrollment con id: " + id);
    }

    public EnrollmentNoEncontradoException(String value) {
        super("No se encontró enrollment: " + value);
    }
}
