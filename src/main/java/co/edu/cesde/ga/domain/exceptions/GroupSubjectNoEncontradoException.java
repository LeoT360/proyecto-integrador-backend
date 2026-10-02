package co.edu.cesde.ga.domain.exceptions;

public class GroupSubjectNoEncontradoException extends ResourceNoEncontradoException {
    public GroupSubjectNoEncontradoException(Long id) {
        super("No se encontró groupsubject con id: " + id);
    }

    public GroupSubjectNoEncontradoException(String value) {
        super("No se encontró groupsubject: " + value);
    }
}
