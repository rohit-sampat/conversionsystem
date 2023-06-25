# conversionsystem
Conversion System converts Metric to Imperial and vice versa 
URL: - 1. http://localhost:80/change/temperature/metric/32

2. http://localhost:80/change/temperature/imperial/45.154

To Run from eclipse – right click on ConversionsystemApplication.java file and run as java application
runs on 80 port (if you need to change the port, please change application.properties which is inside the sr/main/resources folder).
server.port=80
# Tech Stack
1. using Java 15 (to change the java version, just edit pom.xml file <java.version>17</java.version>
2. Springboot application (version 2.4.2)  - Intially i have used springboot 3.1.1 (but with java 15 i am getting unsupportedClassVersionError)
3. Maven for dependency management and build tool
4. Using Junit for unit test and mockito 
5. Postman to test RESTAPI
6. Docker file is in base location - docker run cmd to
7. using Tomcat server which is by-default in built server provided by spring boot
# Functionality
1. Temperature - Convert Fehrenheit to Celsius -> http://localhost:80/change/temperature/metric/32  **AND**  Celsius to Fehrenheit -> http://localhost:80/change/temperature/imperial/45
2. Length - Convert Mile to KM -> http://localhost/change/length/metric/1 **AND** KM to Mile -> http://localhost/change/length/imperial/1
3. Weight - Convert pound to KG -> http://localhost:80/change/weight/metric/1 **AND** KG to Pound -> http://localhost:80/change/weight/imperial/1
(We can add more conversion by adding services into conversionservice package)
