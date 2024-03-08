# JDBC-MySQL-Application
### JDBC NOTES BY Mr.CHETAN GHODEKAR SIR

   ## Q1. What is API ?
          1) API stands for Application Programming Interface.
          2) API is a collection of different interfaces, implementation classes or helper classes. 
          3) The main objective of the creative API is exchange of the info. between two software components.
          4) API mainly classified into 2 types 1)Private API 2)Open API
     
   ## What is JDBC ?
          1) JDBC stands for java database connectivity.
          2) JDBC is a technology which can be used to establish the connection between java and database software.
          3) Incase of JDBC we have to use database API to communicate with database software which is also known as JDBC API.

   ## Java app. can communicate with database app. by using following component of db API
          A)Driver :- is responsible to convert object oriented instructions into
          simple sql format as well as sql info. will be converted into object
          oriented format.
          B)Connection :- It provides a network between java and database
          applications.
          C) Statement :- It acts as an input container. which means we can 
          write sql instruction by using statement object
          D) ResultSet :- It acts as an output Container. which means multiple
          table record will be store into resultset object
          
   ## What is Maven?
         1) Maven is a Project Management tool specifically dev. for javaapplication.
         2) By using Maven we can automate the project Management process.
         3) The Maven tool is developed by Apache Software Foundation.
         4) So with the help of maven developers can easily create project structure.
         5) Superior dependency management i.e. Project will automatic  updating, dependency closure.
            Dependency management :- Maven encourages to use a central repository of jars and other dependencies.
         6) Maven is a build automation tool used primarily for Java projects.
         7) Maven can also be used to build and manage projects written in C#, Ruby, Scala etc.
         
   ## What are the Steps to develop a JDBC app?
         we have to follow 6 steps to developed jdbc app
            1) Load & register the driver -> To dev. JDBC application its  mandatory load and register the driver software.
            2) Establish the connection -> We can establish the connection between java and database applications by using getConnection().
            3)create a statement of platform -> After connection we have to create a statement platform inorder to execute sql query.
         
         We can create platform by using 3 Ways
            A)Statement(Interface)
            B)PreparedStatement(Interface)
            C)CallableStatement(Interface)
         
            4)Execute query -> We can execute sql query by using 3 diff. ways
               1) executeUpdate() can be used for the execution the dml set
               2)executeQuery() can be used to for the execution dql statement
               3)execute() is capable to execute dml as well as dql statement
            
            5)process resultset -> After the execution of the query database server will return a group of multiple records. Which will be present
               inside the result set object.
         
            6)close costly resources -> After JDBC transaction we have to close all the costly resources present inside the java file.
        
   ## How to create platform by using different types of statements
         In JDBC we can create statement platform by using three interfaces
            1)Statement(I)
            2)Prepared Statement(I)
            3)Callable Statement(i)
         
         Statement(I) can be used to create a basic platform to execute sql query.
         Statement(I) is mainly used to execute different sql query.
         In the case of Statement(i) sql query will be compiled and executed for every transaction.in Statement(I) We can't use place holders.
         Prepared Statement(I) extends the properties of statement(I).
         We can use Prepared Statement(I) to execute the same sql query multiple times.In case of prepared Statement(I) sql query will be
         compiled once and executed multiple times.In Prepared Statement(I) Supports Placeholders for dynamic values.
         
   ## What is a placeholder?
         1) A SQL prepared statement in JDBC terms is a complete SQL
         statement with placeholders for values. 
         2) The placeholder is the question mark and is replaced with a value at run time.
         3) A placeholder is a character, word, or string of characters that
         temporarily takes the place of the final data.
         
   ## What is Callable statement ?
         1) A Callable statement is a special purpose statement which can be
            used to execute stored functions and stored procedures.
         2) Callable statement(I) extends the properties of prepared Statement.
         To create a platform by using Callable statements we need to call the
         PrepareCall() method.
         
   ## What is Stored Function ?
         1) Stored Function can be used to develop business logic by using sql.
         2) It acts as a container for different sql statements.
         3) Stored functions are based on reusability components in case
         Database.
         4) To develop a Stored function We have to use special syntax and rules
         of sql.
        
   ## What is the stored procedure ?
        1) Stored procedure acts as a container for multiple sql queries.
        2) We can use stored procedures to execute different sql query at same
        time.
        3) We can not develop simple business logic using procedure.
        
   ## Explain DAO/DTO design pattern
        A) DAO/DTO design pattern is mainly used in the developed of
        database application.
        1) DAO class -> DAO stands for DATA ACCESS OBJECT.
        DAO class is a simple java class where we can develop jdbc logic.
        DAO class directly communicates with database vendors.
        2)DTO class -> DTO stands for DATA TRANSFER OBJECT.
        DTO class is also known as model class/java bean class.
        The DTO class is responsible for transferring the data from one layer
        to another layer.
