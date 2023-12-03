# Task

Simple Spring boot application use for task management

## Prerequisites

- [Java JDK 21](https://www.oracle.com/java/technologies/downloads/)
- [Maven 3.9.6](https://maven.apache.org/download.cgi)
- [MySql 8.0.5](https://dev.mysql.com/downloads/installer/)

## Getting Started

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/hnim1922/task.git
   cd task

2. **Configure MySQL data source**

   In application.properties, change ``spring.datasource.username`` and `` spring.datasource.password``
   ```
   spring.jpa.hibernate.ddl-auto=update
   spring.datasource.url=jdbc:mysql://localhost:3306/da_db
   spring.datasource.username=
   spring.datasource.password=
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
 
 3. **Run the project**
    
    Start the Spring Boot application
    ```
    /.mvn spring-boot:run
    ```
    Here are some endpoints you can call:

    ### Create a new task
        
        POST /tasks
        Accept: application/json
        Content-Type: application/json
        {
        "title" : "Clean table",
        "description" : "Remove unuse thing on table",
        "completed" : "false",
        }
        
        RESPONSE: HTTP 201 (Created)
        Content:
        {
        "id":1
        "title" : "Clean table",
        "description" : "Remove unuse thing on table",
        "completed" : "false",
        }

    ### Get list of task
        
        http://localhost:8080/tasks
        
        Response: HTTP 200
        Content:
        [
           {
           "id":1
           "title" : "Clean table",
           "description" : "Remove unuse thing on table",
           "completed" : "false",
           }
        ]
        

    ### Get task by id
    
         http://localhost:8080/tasks/1
        
         Response: HTTP 200
         Content:
         {
          "id":1
          "title" : "Clean table",
          "description" : "Remove unuse thing on table",
          "completed" : "false",
         }
       

        
    ### Update task
        
        PUT /tasks/1
        Accept: application/json
        Content-Type: application/json
        
        {
          "title" : "Clean table",
          "description" : "Remove unuse thing on table",
          "completed" : "true",
         }
        
        RESPONSE: HTTP 200
        Content:
        {
          "id":1
          "title" : "Clean table",
          "description" : "Remove unuse thing on table",
          "completed" : "true",
         }
    ### Delete task

        DELETE /tasks/1
        Accept: application/json
        Content-Type: application/json

        RESPONSE: HTTP 204 (No Content)
