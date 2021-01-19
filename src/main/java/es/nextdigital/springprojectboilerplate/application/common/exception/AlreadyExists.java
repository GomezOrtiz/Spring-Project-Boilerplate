package es.nextdigital.springprojectboilerplate.application.common.exception;

/**
 * Excepción genérica para controlar errores por intento
 * de creación de un registro que ya existe en base de datos
 */
public class AlreadyExists extends RuntimeException {

    private static final long serialVersionUID = -3922337552091308440L;

    public AlreadyExists(String message, String id) {
        super(String.format(message, id));
    }
}