# delivery-java-spring

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