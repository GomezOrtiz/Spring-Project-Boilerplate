run: start-db
	@./mvnw spring-boot:run

start: start-db
	@docker-compose up -d --build app

logs:
	@docker-compose logs -f app

stop:
	@docker-compose down

status:
	@docker ps -a

cleanup:
	@docker rmi $$(docker images -f "dangling=true" -q)

test:
	@./mvnw clean test

sonar: start-sonar
	@mvn clean verify sonar:sonar

start-sonar:
	@docker-compose up -d sonar

start-db:
	@docker-compose up -d database adminer

clean-db:
	@./mvnw flyway:clean

generate-schema:
	@rm -rf schema.sql
	@./mvnw spring-boot:run -Pdev,schema

.PHONY: run start logs stop status cleanup test sonar start-sonar start-db clean-db generate-schema