package co.edu.cesde.ga.domain.exceptions;

public class TeacherNoEncontradoException extends ResourceNoEncontradoException {
    public TeacherNoEncontradoException(Long id) {
        super("No se encontró teacher con id: " + id);
    }

    public TeacherNoEncontradoException(String value) {
        super("No se encontró teacher: " + value);
    }
}
