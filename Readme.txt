Technology Stack Used

1. Java 1.8
2. Spring Boot 
3. STS 4.0
4. H2 DB
5. Postman
6. JPA

Perform the following steps to run the code.

1. Clone the repository.
2. Open Project in STS (Spring Tools Suit).
3. Import project as "existing mvn project".
4. Run the the projec as Spring Boot Application.
5. This project uses in memory H2 DB.
6. The application required authentication to use it. Spring Security is used to 
   authenticate the user. To access any service (Rest endpoint) user have to first signin
   with the hard coded user name and password (rahil, rahil) using "/signin" endpoint.
7. A json file (EBI_Person.postman_collection.json) is provided with the project
   that can be imported in postman to access and use/test the all the endpoints. 
8. A jar is also provided along with the code which can be deployed indepndenly.
9. To run the application from jar, install java 8 and run the following command from shell/cmd.
   java - jar person-api-0.0.1-SNAPSHOT.jar




