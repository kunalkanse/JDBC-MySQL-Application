
# Step 1)
## Register the driver class : 
    The forName() method of Class class is used to register the driver class. 
    This method is used to dynamically load the driver class.

    Syntax : Class.forName("com.mysql.cj.jdbc.Driver");
    
The Class class is located in the java.lang package, so it is distributed with java, and imported automatically into every class.

What the forName() method does, is just return the Class object for the parameter that was loaded by the class loader. 
we need to pass argument as Path of the Driver Class as "com.mysql.cj.jdbc.Driver".
The newInstance() method then returns a new instance of the class.

So then what happens is when you call Class.forName(...) it returns com.mysql.jdbc.Driver.class. 
You then call newInstance() on that class which returns an instance of the class, with no parameters, so it's basically calling new com.mysql.jdbc.Driver();.
