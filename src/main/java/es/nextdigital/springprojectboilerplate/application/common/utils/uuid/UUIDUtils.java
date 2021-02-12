package es.nextdigital.springprojectboilerplate.application.common.utils.uuid;

import es.nextdigital.springprojectboilerplate.application.common.exception.ExceptionConstants;
import es.nextdigital.springprojectboilerplate.application.common.utils.uuid.exception.UUIDNotValid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

import java.util.UUID;

/**
 * Clase de utilidad con métodos para trabajar con UUID
 */
@Slf4j
public final class UUIDUtils {

    public static UUID fromString(String id) {
        Assert.notNull(id, ExceptionConstants.ID_REQUIRED);
        try {
            return UUID.fromString(id);
        } catch(IllegalArgumentException e) {
            log.warn(String.format(ExceptionConstants.UUID_NOT_VALID, id));
            throw new UUIDNotValid(id);
        }
    }
}
