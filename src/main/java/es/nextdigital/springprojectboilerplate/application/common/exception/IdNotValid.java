package es.nextdigital.springprojectboilerplate.application.common.exception;

/**
 * Excepción para controlar errores producidos
 * por el envío de un valor de ID inadecuado
 */
public class IdNotValid extends NotValid {

    private static final long serialVersionUID = -5189180219113044542L;

    public IdNotValid(String id) {
        super(ExceptionConstants.ID_NOT_VALID, id);
    }
}
