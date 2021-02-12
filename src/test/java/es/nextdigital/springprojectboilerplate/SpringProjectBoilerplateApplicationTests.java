package es.nextdigital.springprojectboilerplate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SpringProjectBoilerplateApplicationTests extends BaseIntegrationTest {

	@Test
	void contextLoads() {
		assertTrue(Boolean.TRUE);
	}

}
