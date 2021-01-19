package es.nextdigital.springprojectboilerplate.application.common.exception;

/**
 * Excepción genérica para controlar errores por intento
 * de realizar una operación no permitida
 */
public class NotAllowed extends RuntimeException {

    private static final long serialVersionUID = 150763419930324638L;

    public NotAllowed(String message) {
        super(message);
    }
}
