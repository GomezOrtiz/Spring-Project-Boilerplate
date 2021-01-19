# NEXT DIGITAL HUB - SPRING PROJECT BOILERPLATE
### Boilerplate code to quickstart a Spring Boot project.

## LOCAL DEVELOPMENT

To run in localhost:8080, use your IDE (with the default profile "dev" active) or execute this Make target:

```make run```

Please note that you should already have a Postgres database with the required configuration running in localhost:5432. The best way to do it is by executing the following Make target, which will run an appropiate Docker container:

```make start-db```

#### GENERATE SCHEMA

To generate a schema.sql file in root folder with any database scripts Hibernate would automatically run to create and alter the required tables and their relations, just execute the following Make target:

```make generate-schema```

You could also use your IDE to run the app with "schema" profile active alongside the default "dev" profile.

#### CLEAN DATABASE

To clean the dockerized Postgres database we use for dev environment, run the following Make target:

```make clean-db```

#### API SPEC AND POSTMAN COLLECTION

While the app is up and running, Swagger API docs are available in the following URL:

http://localhost:8080/api/spec

## CI / CD

Pushes to any branch will trigger tests execution.

Pushes to develop will trigger coverage reporting.