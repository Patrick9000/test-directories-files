# test-directories-files
### Getting started 
#### Database
* Set up MySQL 5+ db server.
* Make sure database uses UTF-8 encoding. (Otherwise cyrillic symbols will turn into question marks)
* In /src/main/resources/application.properties configure connection to db
```
#url to db
spring.datasource.url=jdbc:mysql://*host*:*port*/*schema*?serverTimezone=UTC&useSSL=false
#user to access db
spring.datasource.username=*username*
spring.datasource.password=*password*
```
#### Application
* Need JRE 1.8
* [Main page of application](http://localhost:8080)

