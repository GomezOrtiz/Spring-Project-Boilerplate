package es.nextdigital.springprojectboilerplate.application.common.exception;

import java.util.Collections;
import java.util.List;

/**
 * Excepción genérica para controlar errores
 * producidos por el envío de un valor inadecuado
 */
public class NotValid extends RuntimeException {

    private static final long serialVersionUID = -4764907039065280816L;

    private List<String> errors;

    public NotValid(String message, Object... args) {
        super(String.format(message, args));
        this.errors = Collections.singletonList(String.format(message, args));
    }

    public NotValid(List<String> errors, String message, Object... args) {
        super(String.format(message, args));
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }
}
