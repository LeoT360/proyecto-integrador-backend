package co.edu.cesde.ga.domain.exceptions;

public class StudentNoEncontradoException extends ResourceNoEncontradoException {
    public StudentNoEncontradoException(Long id) {
        super("No se encontró student con id: " + id);
    }

    public StudentNoEncontradoException(String value) {
        super("No se encontró student: " + value);
    }
}
