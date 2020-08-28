# basic-spring-security

(Spring Boot + Spring Data JPA + Spring Security + User Pagination with Pageable) Application 

## Profiles
* dev

## Prepare DB
```
docker pull mysql
docker run --name=mysql -d -p 3306:3306 -e "MYSQL_ROOT_PASSWORD=root" -e "MYSQL_DATABASE=main" -e "MYSQL_USER=test" -e "MYSQL_PASSWORD=test" mysql:latest
```

## Build
```
mvn clean install
```

## Usage
```
java -jar basic-spring-security.jar
```

## Authors - Version 4.0
* Emin İnal
