package co.edu.cesde.ga.domain.exceptions;

public class ProgramNoEncontradoException extends ResourceNoEncontradoException {
    public ProgramNoEncontradoException(Long id) {
        super("No se encontró program con id: " + id);
    }

    public ProgramNoEncontradoException(String value) {
        super("No se encontró program: " + value);
    }
}
