run:
	@./mvnw spring-boot:run

test:
	@./mvnw clean test

generate-schema:
	@rm -rf schema.sql
	@./mvnw spring-boot:run -Pdev,schema

start-db:
	@docker run --rm -d -p 5432:5432 \
		-e POSTGRES_DB=boilerplate -e POSTGRES_USER=boilerplate -e POSTGRES_PASSWORD=b0il3rpl4t3 \
		-v vacaciones-db-data:/var/lib/postgresql/data \
		--name vacaciones_db postgres:12-alpine

clean-db:
	@./mvnw flyway:clean

.PHONY: run test generate-schema start-db clean-db