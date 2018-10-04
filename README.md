# CSRF Protection - Synchronize Token Pattern Demo
This is a demonstration application on Synchronize Token Pattern CSRF Protection. More information on this project will be available at [http://computeinbasics.blogspot.com/2018/08/csrf-defence-synchronizer-token-pattern_27.html](http://computeinbasics.blogspot.com/2018/08/csrf-defence-synchronizer-token-pattern_27.html)


## Technologies
- Java 8
- Spring Boot 2.0.4
- Bootstrap
- jQuery

## System Requirements
- Java 8 or grater.
- Apache Maven.
- Working internet connection (scripts and css imported by online cdn)

## Running Steps
- Clone this repository into your local file system. 
- Navigate into the cloned project folder using command prompt (terminal).
- Issue this command `mvn clean package` to build the project.
- Then issue following command to run the application.
`java -jar target\cross-site-request-synchronizer-demo-0.0.q-SNAPSHOT.jar`
- Now the server will start on port 8080.
- In case of 8080 port is already reserved in your pc, you can specify different port in running command. For example if you want to start server in 8090 port, you can issue following command.
 `java -jar target\cross-site-request-synchronizer-demo-0.0.q-SNAPSHOT.jar --server.port=8090`
 
## Default login credentials
- Username - user
- Password - pwd