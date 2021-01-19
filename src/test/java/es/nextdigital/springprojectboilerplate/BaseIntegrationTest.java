package es.nextdigital.springprojectboilerplate;

import es.nextdigital.springprojectboilerplate.config.AppProfiles;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.PostgreSQLContainer;

import javax.persistence.EntityManager;

@Slf4j
@Rollback
@Transactional
@SpringBootTest
public abstract class BaseIntegrationTest {

    private static final String POSTGRES_IMAGE = "postgres:12-alpine";

    @Autowired
    protected EntityManager em;

    static {
        if(System.getProperty("runner") == null) {
            System.setProperty("spring.profiles.active", AppProfiles.TEST);
            PostgreSQLContainer postgres = new PostgreSQLContainer(POSTGRES_IMAGE);
            postgres.start();
            System.setProperty("spring.datasource.url", postgres.getJdbcUrl());
            System.setProperty("spring.datasource.username", postgres.getUsername());
            System.setProperty("spring.datasource.password", postgres.getPassword());
            log.info("Postgres 12 Alpine container created with the following values. URL: " + postgres.getJdbcUrl() + " USERNAME:" + postgres.getUsername() + " PASSWORD: " + postgres.getPassword());
        }
    }
}
