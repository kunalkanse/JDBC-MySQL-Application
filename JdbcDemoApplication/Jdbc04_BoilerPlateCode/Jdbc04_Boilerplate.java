package JdbcDemoApplication.Jdbc05_BoilerMain;

// This is generalized class which contains common code which is required for very JDBC application

import java.sql.*;

public class Jdbc04_Boilerplate {
    
    Statement statement = null; 
    // Connection conn = null; 
    
    public void setConnection(){
        try {
            statement = DriverManager.getConnection("jdbc:mysql://localhost:3306/empj2ee","root","Kunal@447").createStatement();
            
            // Most of the cases we have to return Object of Connection Only because based on Requirment we may need Statement, PreparedStatement or callableStatement
            // conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/empj2ee","root","Kunal@447")
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Statement getStatement() {
        return statement;
        // return conn;
    }
}
