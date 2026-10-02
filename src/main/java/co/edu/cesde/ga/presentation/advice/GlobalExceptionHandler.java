package co.edu.cesde.ga.presentation.advice;

import co.edu.cesde.ga.domain.exceptions.ResourceConflictoException;
import co.edu.cesde.ga.domain.exceptions.ResourceNoEncontradoException;
import co.edu.cesde.ga.domain.exceptions.ResourceYaExistenteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceYaExistenteException.class)
    public ResponseEntity<String> handleResourceAlreadyExistsException(
            ResourceYaExistenteException ex) {

        String message = ex.getCause() != null
                ? ex.getCause().getMessage()
                : ex.getMessage();

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(message);
    }

    @ExceptionHandler(ResourceNoEncontradoException.class)
    public ResponseEntity<String> handleResourceNotFoundException(
            ResourceNoEncontradoException ex) {

        String message = ex.getCause() != null
                ? ex.getCause().getMessage()
                : ex.getMessage();

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(message);
    }

    @ExceptionHandler(ResourceConflictoException.class)
    public ResponseEntity<String> handleResourceConflictException(
            ResourceConflictoException ex) {

        String message = ex.getCause() != null
                ? ex.getCause().getMessage()
                : "Ocurrio un conflicto";

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(message);
    }
}
