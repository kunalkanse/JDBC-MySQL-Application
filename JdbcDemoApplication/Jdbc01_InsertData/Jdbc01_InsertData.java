package JdbcDemoApplication.Jdbc01_InsertData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc01_InsertData {
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;

        String query = "insert into emp1 values(1,'aniket','test',38000)";

        try {
            // STEP 1 : LOAD & REGISTER DRIVER (OPTIONAL)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // STEP 2  ESTABLISH CONNECTION
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empj2ee", "root","Kunal@447");

            // STEP 3 : CREATE STATEMENT PLATFORM
            statement = connection.createStatement();

            // STEP 4 : EXECUTE SQL QUERY
            int count = statement.executeUpdate(query);

            // STEP 5 : PROCESS THE DATA
            System.out.println(count + "DATA INSERTED");
        }
        catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            // STEP 6 : Close Costly Exception
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


