package es.nextdigital.springprojectboilerplate;

import es.nextdigital.springprojectboilerplate.config.AppProfiles;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.Network;
import org.testcontainers.containers.PostgreSQLContainer;

import javax.persistence.EntityManager;
import java.util.List;

@Slf4j
@Rollback
@Transactional
@SpringBootTest
public abstract class BaseIntegrationTest {

    private static final String POSTGRES_IMAGE = "postgres:12-alpine";
    private static final String DB_HOST_NAME = "db";

    @Autowired
    protected EntityManager em;

    static {
        if(System.getProperty("runner") == null) {
            Network dbNetwork = Network.newNetwork();

            PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(POSTGRES_IMAGE);
            postgres.setNetwork(dbNetwork);
            postgres.setNetworkAliases(List.of(DB_HOST_NAME));
            postgres.start();

            GenericContainer<?> adminer = new GenericContainer<>("adminer:4.7.8")
                    .withExposedPorts(8080)
                    .withNetwork(dbNetwork);
            adminer.start();

            log.info("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            log.info("Postgres 12 test database can be accessed via Adminer in http://localhost:" + adminer.getMappedPort(8080) + " with HOST " + DB_HOST_NAME + ", DATABASE " + postgres.getDatabaseName() + ", USERNAME " + postgres.getUsername() + " and PASSWORD " + postgres.getPassword());
            log.info("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

            System.setProperty("spring.profiles.active", AppProfiles.TEST);
            System.setProperty("spring.datasource.url", postgres.getJdbcUrl());
            System.setProperty("spring.datasource.username", postgres.getUsername());
            System.setProperty("spring.datasource.password", postgres.getPassword());
        }
    }
}
