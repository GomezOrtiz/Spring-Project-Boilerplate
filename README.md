# NEXT DIGITAL HUB - SPRING PROJECT BOILERPLATE
### Boilerplate code to quickstart a Spring Boot project.

## INSTRUCCIONES DE USO:

1. Modifica la información sobre el proyecto en el pom.xml:

	```<groupId>es.nextdigital</groupId>```
	```<artifactId>spring-project-boilerplate</artifactId>```
	```<name>spring-project-boilerplate</name>```
	```<description>Boilerplate code to quickstart a Spring Boot project</description>```
   

2. Renombra (con Refactor > Rename) las carpetas principales del proyecto:

    ```src/main/java/es.nextdigital.springprojectboilerplate```
    ```src/test/java/es.nextdigital.springprojectboilerplate```

3. Renombra las clases principales del proyecto, SpringBootBoilerplateApplication y SpringBootBoilerplateApplicationTests.

4. Modifica el BASE_PACKAGE en BaseArchTest.java en base al nuevo nombre que hayas elegido en el paso anterior.


5. Modifica la información sobre el proyecto en SwaggerConfig.java


6. Comprueba si hay versiones más recientes de las dependencias que se especifican en el pom.xml y decide si te interesa actualizarlas. De ser así, cambia el número de versión en "properties".


7. Modifica la información sobre la base de datos en todos los sitios donde se utiliza:

- En el Makefile, en el comando que levanta el contenedor de Postgres de la base de datos de dev ("start-db").
  

- En el gitlab-ci.yml, en la configuración del service de Postgres que utiliza la stage de test.
  

- En el pom.xml, en el apartado de configuración de Flyway. Deberás usar los mismos datos que en Makefile para el perfil "dev" y los mismos que en el gitlab-ci.yml para el perfil "runner".
  

- En application-dev.yml. Deberás usar los mismos datos que en el Makefile.
  

- En application-runner.yml. Deberás usar los mismos datos que en el gitlab-ci.yml.


8. Borra este archivo (README.md) y renombra el archivo ACTUAL_README.md a README.md. Modifica el título y la descripción del proyecto.
	
	
