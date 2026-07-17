
# SpringBoot 

## Restcontroller 
It marks the class which handles the incoming requests.

### @RestController
- marks class as entry point for client communication.
    - It's a specialized form of Spring's `@Controller` combined implicitly with `@ResponseBody`

### @Service
- Designates a class as the 'brain' or The business logic driver of your application.

### @Repository
- marks the class or interface as a Data Access Object (DAO) that communication directly with database.


## Jackson 
It converts JSON <-> Java Objects

 - It is primarily responsible for converting Java objects into JSON strings (Serialization) and translating incoming JSON request data back into Java objects (Deserialization) 



### Detail:
 - StudentServer X(Not used)   -> StudentController 
 - StudentRepository -> it should be interface and its method should be implemented by other class.
 - H2 Database, saves the data into RAM. You can also change it to files from mem(memory ram).
   changes to be done:
   ```bash
        # In-Memory Configuration (Data is lost on restart)
        spring.datasource.url=jdbc:h2:mem:testdb

        # File-Based Configuration (Data persists in your user current working directory as test.mv.db)
        spring.datasource.url=jdbc:h2:file:./test
   ```

## Related Images

<div> 
    <p>Flow of springboot</p>
    <img src ="Images/Flow.png">
    <img src ="Images/Flow2.png" width=250px>
    <p>Spring auto update DDL config details</p>
    <img src ="Images/Flow3.png"> 
</div>