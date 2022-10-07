# delivery-java-spring

## Discription
- Implement RESTful API with Java and Spring Boot framework
- Controller and Service structure
- PostgreSQL database running on a Docker container

## Objectives
- Practice Java and Spring Boot framework
- Improve backend skills

## Settings
### Installation
- [Homebrew](https://brew.sh/)
  ```bash
  /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
  ```
- [SDKMAN](https://sdkman.io/)
    ```bash
    curl -s "https://get.sdkman.io" | bash
    ```
- Java
    ```bash
    sdk list java
    sdk install java 17.0.3-zulu
    ```
- Maven
    ```bash
    sdk install maven 3.8.4
    ```
- [Spring](https://start.spring.io/)<br>
  [example](https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.7.4&packaging=jar&jvmVersion=17&groupId=github.com%2Fleehaowei%2F&artifactId=delivery-java-spring&name=delivery-java-spring&description=Demo%20project%20for%20Spring%20Boot&packageName=github.com%2Fleehaowei%2F.delivery-java-spring&dependencies=web,data-jpa,postgresql)
- [Docker Desktop](https://www.docker.com/products/docker-desktop/)
- [docker-compose](https://formulae.brew.sh/formula/docker-compose)

### Repository
- Create Directory
    ```bash
    mv ~/Downloads/delivery-java-spring.zip ~/Desktop
    cd ~/Desktop
    unzip delivery-java-spring.zip
    ```
- Open the Directory with IntelliJ

## Implementation
### Step 1
- comment out jpa in `pom.xml` before implementing database
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```
- Right click `pom.xml` > Maven > Reload project 
- Create `order` package
- Create `Order` Class
- `⌘` + `N` to generate
  - Constructor
  - Getter and Setter
  - toString() method
  
### Step 2
- Create order package and Order Class under the package
- Implement OrderController and OrderService Class

### Step3
- Update `application.properties` under `src/main/resources/application.properties`
- Create `docker-compose.yml`
- Create [Makefile](https://makefiletutorial.com/) for convenience
- Make sure the credentials in `application.properties` align with that in `docker-compose.yml`
- Run `docker compose up` to set up postgresql database
- Run `make db.console` to inspect the database
- uncomment jpa in `pom.xml`
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```
- Right click `pom.xml` > Maven > Reload project

### Step4
- Apply @Entity and @Table annotation in Order Class
- Potential error: `GenerationTarget encountered exception accepting Error executing DDL`
  - solution: see Q&A - 2

## Q&A
1. [What is the purpose of mvnw and mvnw.cmd files?](https://stackoverflow.com/questions/38723833/what-is-the-purpose-of-mvnw-and-mvnw-cmd-files)
2. How to solve `GenerationTarget encountered exception accepting Error executing DDL`<br>
   Add `spring.jpa.properties.hibernate.globally_quoted_identifiers=true` to `application.properties`
   - [reference1](https://jtuto.com/solved-generationtarget-encountered-exception-accepting-error-executing-ddl/#:~:text=spring.jpa.properties.hibernate.globally_quoted_identifiers%3Dtrue)
   - [reference2](https://docs.spring.io/spring-boot/docs/1.3.0.M2/reference/html/boot-features-sql.html#boot-features-creating-and-dropping-jpa-databases:~:text=spring.jpa.properties.hibernate.globally_quoted_identifiers%3Dtrue)
   

## Reference
- [Project idea](https://github.com/woltapp/engineering-summer-intern-2022)
- Same project concept implemented in other programming languages
  - [Python + FastAPI](https://github.com/leehaowei/delivery-py-fastapi)
  - [Javascript + Express](https://github.com/leehaowei/delivery-js-express)
- [Free Spring Boot tutorial](https://youtu.be/9SGDpanrc8U)

## Shorcuts - IntelliJ
- `⌘` + `N`: Generate
- `⌘` + `⌥` + `V`: Introduce Variable