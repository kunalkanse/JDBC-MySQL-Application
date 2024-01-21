
### STEP 1 : Load & Register Driver
  Class.forName("com.mysql.cj.jdbc.Driver");
  
### STEP 2 : ESTABLISH THE CONNECTION
  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empj2ee", "root","Pass@123");

### STEP 3 : CREATE STATEMENT PLATFORM
  Statement stmt = connection.createStatement();

### STEP 4 : EXECUTE SQL QUERY
  int count = stmt.executeUpdate("insert into emp1 values(1,'aniket','test',38000)");  // DML
  
  Resultset rs = stmt.executeQuery("select * from emp");  // DQL

### STEP 5 : PROCESS THE DATA

### STEP 6 : CLOSE CONSTLY RESOURCES
  connection.close();
