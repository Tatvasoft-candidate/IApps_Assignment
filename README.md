IApps_Assignmnt
This is a utility to upload XML File and validate XML against XSD schema and after that the required data will be parsed and saved in MySQL DataBase

Liquibase is used to create Database(iapps) and table news_paper automatically.

You just have to give name of schema and some minor configurations.

First you have to configure database properties in src/resources/application.yml

Please refer some configurations for liquibase which are done in /resource folder regarding Database and creation of table(includes schema.sql,db.changelog-master.xml)

Following are the Rest-EndPoints which are exposed to execute operations like uploading xml file and validating them and persisting them in DataBase

PostMapping :-

http://localhost:8080/upload

this api requires a multipart file as a request param  in body which is nothing but your xml which needs to be verified and persistd in DataBase

GetMapping :-

http://localhost:8080/newspapers

Get Mapping by Name

http://localhost:8080/newspapers?name=""

this api is used for getting all the  newspaper data. if you want to search newspaper according to newspapernames then use

Pagination properties has already been enabled for the APIs.

Steps to run the project:-
1) Run the MySQL container in docker with the following command.
  docker run -d -p 3307:3306 --name mysqldb -e MYSQL_ROOT_PASSWORD=<password> -e MYSQL_DATABASE=iapps mysql:8
  
2) Add following VM Arguments in Run Configurations of the Project
-DMYSQL_HOST=mysqldb
-DMYSQL_PORT=3307
-DMYSQL_USER=root
-DMYSQL_PASSWORD=your_db_password
Note: Please change your db_password in application.properties and .

3) Run below command to build jar.
  mvn clean install
  
4) Stop & Remove mysql container in docker by following command.
  docker stop <container_id>
  docker rm <container_id>
  
5) Once jar is built, Run the project by docker-compose.
  docker-compose up --build.
  
Project will run in the above url.

To check Data in mysql container in docker
Please execute these commands.

1) docker container exec -it <container-id> bash
2) mysql -u<root_name> -p<password> -> accroding to docker-compose.
3) show databases;
4) use <db_name>
5) Execute DQL Queries.


Note: Please ensure that db properties in application.properties and in docker-compose file should be same.
