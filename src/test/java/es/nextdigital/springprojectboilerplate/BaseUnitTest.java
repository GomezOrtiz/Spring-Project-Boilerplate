package es.nextdigital.springprojectboilerplate;

import es.nextdigital.springprojectboilerplate.config.AppProfiles;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles(AppProfiles.TEST)
public abstract class BaseUnitTest {
}
