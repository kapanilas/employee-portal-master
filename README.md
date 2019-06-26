# employee-portal-master
SocGen Employee Portal Test

#Build
To install dependencies of service: gradle clean install
To build service use command: gradle clean build
To install dependencies of UI: npm install
To run the UI: ng serve
To build UI: ng build --prod for production build

#Running the project
Run the project using the following steps:

1. Build the service using the command gradle clean build
2. Open a commmand prompt and redirect to <path to employeeportal-service>/build/libs
3. Execute the command java -jar employeeportal-1.0.0.jar
4. Open another command prompt and redirect to <path to employeeportal-client>
5. Install the dependencies by executing the command: npm install
6. run the command: ng serve
7. Open browser and hit the url localhost:4200/index.html

Note: service should runn on 8080 port and UI should run on 4200 port.

#Swagger
Swagger Documentation: http://localhost:8080/v2/api-docs
Swagger UI: http://localhost:8080/employeeportal
