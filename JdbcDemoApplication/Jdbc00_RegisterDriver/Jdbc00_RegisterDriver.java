package JdbcDemoApplication;

public class Jdbc00_ReginsterDriver {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException();
        }
    }
}

/*
The Class class is located in the java.lang package, so it is distributed with java, and imported automatically into every class.

What the forName() method does, is just return the Class object for the parameter that was loaded by the class loader. 
"com.mysql.cj.jdbc.Driver" is the path to the Driver Class.
The newInstance() method then returns a new instance of the class.

So then what happens is when you call Class.forName(...) it returns com.mysql.jdbc.Driver.class. 
You then call newInstance() on that class which returns an instance of the class, with no parameters, so it's basically calling new com.mysql.jdbc.Driver();
*/
