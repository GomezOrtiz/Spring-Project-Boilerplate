package es.nextdigital.springprojectboilerplate.unit.application.common.utils.uuid;

import es.nextdigital.springprojectboilerplate.BaseUnitTest;
import es.nextdigital.springprojectboilerplate.application.common.exception.ExceptionConstants;
import es.nextdigital.springprojectboilerplate.application.common.utils.uuid.exception.UUIDNotValid;
import es.nextdigital.springprojectboilerplate.application.common.utils.uuid.UUIDUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UUIDUtilsTests extends BaseUnitTest {

    @Test
    void should_parse_uuid_from_string() {

        String id = "83dd97c2-64af-4a82-b8af-ffa3d00f51ce";

        assertNotNull(UUIDUtils.fromString(id));
    }

    @Test
    void should_fail_parse_uuid_from_string_if_null_id() {
        assertThrows(IllegalArgumentException.class, () -> UUIDUtils.fromString(null));
    }

    @Test
    void should_fail_parse_uuid_from_string_if_not_valid() {

        String id = "wrong";

        Exception e = assertThrows(UUIDNotValid.class, () -> UUIDUtils.fromString(id));

        assertEquals(String.format(ExceptionConstants.UUID_NOT_VALID, id), e.getMessage());
    }
}
