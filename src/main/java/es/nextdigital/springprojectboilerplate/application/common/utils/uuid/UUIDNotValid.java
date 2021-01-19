package es.nextdigital.springprojectboilerplate.application.common.utils.uuid;

import es.nextdigital.springprojectboilerplate.application.common.exception.ExceptionConstants;
import es.nextdigital.springprojectboilerplate.application.common.exception.NotValid;

/**
 * Excepción para controlar errores producidos
 * por el envío de un valor de UUID inadecuado
 */
public class UUIDNotValid extends NotValid {

    private static final long serialVersionUID = -6511818867026757228L;

    public UUIDNotValid(String id) {
        super(ExceptionConstants.UUID_NOT_VALID, id);
    }
}
