package co.edu.cesde.ga.domain.exceptions;

public class PeriodNoEncontradoException extends ResourceNoEncontradoException {
    public PeriodNoEncontradoException(Long id) {
        super("No se encontró period con id: " + id);
    }

    public PeriodNoEncontradoException(String value) {
        super("No se encontró period: " + value);
    }
}
