# JavaExerciseINNOCV
Java exercise for the technical interview at INNOCV

For installing the project, just import it as an existing maven project.

For executing the project in your IDE, right click on the file JavaExerciseApplication -> Run as -> Java Application.

List of CRUD methods:

  - GET: http://localhost:8080/api/users/ Get all the users from the database
  - GET: http://localhost:8080/api/users/{id} Get the user with id = {id} from the database
  - POST: http://localhost:8080/api/users/ Create a new user in the database
    - Body format example:
      {
        "name" : "Test",
        "birthdate" : "04-04-2020"
      }
  - PUT: http://localhost:8080/api/users/{id} Update the data of the user with id = {id}
    - Body format example:
      {
        "name" : "TestUpdate",
        "birthdate" : "04-04-2020"
      }
  - DELETE: http://localhost:8080/api/users/{id} Delete the user with id = {id}
    
As seen, the format chosen for inserting dates from the JSON is dd-MM-yyyy.
This can be changed in the file application.properties via the property 'spring.jackson.date-format'

For accesing the database, paste this url into the navigator: http://localhost:8080/h2/
The parameters to get into de database are:
  - Driver Class: org.h2.Driver
  - JDBC URL: jdbc:h2:mem:testdb
  - User Name: sa
  - Password: sa
User name and password can be changed in the appplication.properties file via the properties 'spring.datasource.username' and 'spring.datasource.password'

The application has been tested with the IDE Spring Tool Suite 4 Version: 4.6.0.RELEASE, Maven 3.6.3, Java 8 and Spring Boot 2.2.6
