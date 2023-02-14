# IApps_Assignment

Following are the end-points to test http://localhost:8080/upload -> File Upload. 

http://localhost:8080/newspapers -> To fetch All Records of NewsPaper. 

http://localhost:8080/newspapers/name?name= -> To fetch particular record of NewsPaper by Name.

XML File is also validated against XSD Schema.

Above mentioned endpoints are enabled with paginated properties like sorting, pagination and filtering.

Schema is created using liquibase.

Schema/Database -> iapps 
Table - Iapps

Steps to run -> Run docker compose file by following command.

(docker-compose up --build) from the project working directory
