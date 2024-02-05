package JdbcDemoApplication.jdbc06_RetrivingUsingColumnNo;

import java.sql.*;

public class Jdbc06_RetrieveUsingColumnNo {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empj2ee","root","Kunal@447");
            statement = connection.createStatement();

            rs = statement.executeQuery("select emp_name,emp_sal from emp1");

            // without using rs.next(), Exception occurs. Even if resultSet has only one row Still need to check
            while(rs.next()){
                System.out.println(rs.getString(1)+"\t\t"+rs.getString(2));
                // Retrieving Using column No
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
