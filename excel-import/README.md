# Excel Import Application

## Prerequisites:
* [Java 16](https://www.oracle.com/java/technologies/javase/jdk16-archive-downloads.html)

* [InteliJ IDEA](https://www.jetbrains.com/idea/download/)

* [Docker](https://www.docker.com/products/docker-desktop/)

## Running the application:

### Maven build:

In order to run the application you must first execute a maven clean and install commands from the InteliJ terminal
using the following command:

>mvn clean install -DSkipTests

or by executing the maven configuration **excel-import[clean, install, -DskipTests]**

### Running the Docker container:

After a successful maven run please run the Docker application and execute the following commands in the IntelliJ
terminal:

>docker-compose -f .\docker\docker-compose.yml build

Will build the Docker container using the **docker-compose.yml** file.

>docker-compose -f .\docker\docker-compose.yml up

Will run the previously built Docker container.

## Using the application APIs (Swagger)

In order to use the application APIs after running the application please navigate to the following URL in your browser:

>http://localhost:8080/swagger-ui/index.html

This will open the Swagger documentation with three endpoints. You will first need to authenticate using the **/authenticate**
endpoint. You can use the following request body in order to get the JWT authorization token:

```json
{
  "username": "Marta",
  "password": "marta1234"
}
```

Now you will be able to use the other two endpoints with their corresponding CSV files.

##Verifying the results

You can verify that the Excel import was successful by navigating to the following url in your browser:

>http://localhost:5050/

When prompted to log in please enter the following credentials:

>**Email:** marta@postgresadmin.com

>**Password:** B6sgrRFF

After the login you will need to create a server connection to the docker database by registering a new server.
Right-click the Servers tab and select Register -> Server. 
Please enter the following credentials when registering a new server in the connection tab:

>**Hostname:** postgres

>**Port:** 5432

>**Maintained Database:** vacation-dates-db

>**Username:** Marta

>**Password:** VFek3NFt

You can than verify the results by inspecting the relevant database table for which the results have been inserted.



