package es.nextdigital.springprojectboilerplate.application.common.exception;

/**
 * Excepción genérica para controlar errores por registro
 * no encontrado en base de datos a partir de su identificador
 */
public class NotFound extends RuntimeException {

    private static final long serialVersionUID = -774351727254915884L;

    public NotFound(String message, String id) {
        super(String.format(message, id));
    }
}