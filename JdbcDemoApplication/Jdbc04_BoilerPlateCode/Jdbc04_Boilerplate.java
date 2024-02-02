package JdbcDemoApplication.Jdbc05_BoilerMain;

import java.sql.*;

public class Jdbc04_Boilerplate {
    Statement statement = null;

    public void setConnection(){
        try {
            statement = DriverManager.getConnection("jdbc:mysql://localhost:3306/empj2ee","root","Kunal@447").createStatement();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Statement getStatement() {
        return statement;
    }
}
