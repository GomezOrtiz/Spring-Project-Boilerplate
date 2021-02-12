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


5. Modifica la información sobre el proyecto en SwaggerConfig.java. Revisa también CorsConfig.java por si el puerto en el que se levanta tu frontend es distinto del que está configurado por defecto (aunque más adelante deberás añadir configuraciones de CORS para los demás entornos)


6. Modifica la información sobre la base de datos en todos los sitios donde se utiliza:

- En el docker-compose.yml, tanto en el contenedor de app como en el contenedor database.
  

- En el gitlab-ci.yml, en la configuración del service de Postgres que utiliza la stage de test.
  

- En el pom.xml, en el apartado de configuración de Flyway. Deberás usar los mismos datos que en Makefile para el perfil "dev" y los mismos que en el gitlab-ci.yml para el perfil "runner".
  

- En application-dev.yml. Deberás usar los mismos datos que en el docker-compose.yml.
  

- En application-runner.yml. Deberás usar los mismos datos que en el gitlab-ci.yml.


7. Cambia todas las apariciones de la palabra "boilerplate" en el docker-compose.yml por un identificador de tu app (mejor si es también una sola palabra).


8. Cambia la propiedad <sonar.password> en la sección properties del pom.xml. Sigue los pasos que se indican en ACTUAL_README.md para la configuración inicial de Sonarqube.


9. Borra este archivo (README.md) y renombra el archivo ACTUAL_README.md a README.md. Modifica el título y la descripción del proyecto.


10. Borra la carpeta .git de la raíz del proyecto y ejecuta el comando "git init" en tu terminal para crear un nuevo repositorio local (si no lo haces, seguirá sobre el repositorio de este boilerplate). Ya puedes asociar el remoto que prefieras (por ejemplo, un proyecto de Gitlab)


¡NOTA! Recuerda borrar los archivos .gitkeep a medida que vayas introduciendo contenido en las carpetas que los contienen. Solo están ahí para poder subir carpetas vacías al repositorio.

¡NOTA 2! Si utilizas IntelliJ, borra el archivo spring-project-boilerplate.iml para que vuelva a generarlo con el nombre correcto.
	
	
