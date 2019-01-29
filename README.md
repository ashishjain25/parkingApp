****************************************************************************************************************************
************************************************ Parking App*******************************************************
****************************************************************************************************************************
ParkingApp covers the followingn functional aspects:
1) View available parking spots and book a parking spot.
2) Cancel reserve parking spot.


Technology Stack:
------------------

1) Java
2) MAVEN
3) Spring-Boot
4) Spring
5) Hibernate (used by Spring boot internally)
6) Tomcat JDBC pool
7) Postgres DB

It has two modules:
1) parking-webapp to conain UI pages and client code to call restcontroller.
2) parking-lib which is a jar module.


Steps to start the application:
---------------------------------
1) Build the application using either of the below commands:
     'mvn clean install' or 'mvn clean package'

2) Setup DB connection details and install database using the script present in ' supplierCatalogApp/extras/databaseScript':
     ./db_creation_script.sh

   DB connection details can be set in dbConnectionDetails.env present in the same location.
   Note: DB creatials are created in a text file at the the same location

3) Run executable jar using the below command with appropriate path to the jar location:
     java -jar parking-lib/target/parking-lib-1.0-SNAPSHOT.jar

NOTE: logs are written in a file parkingApp/parking/logs/parking.log. Default log level is info and can be set to debug by updating in logback.xml in the jar file or before application is build.


