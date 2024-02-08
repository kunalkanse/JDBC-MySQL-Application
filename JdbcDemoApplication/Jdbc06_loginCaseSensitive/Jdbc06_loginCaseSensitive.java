package JdbcDemoApplication.Jdbc07_loginCaseSensitive;

import java.sql.*;
import java.util.Scanner;

public class Jdbc06_loginCaseSensitive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        boolean status = false;

        System.out.print("Enter UserName : "); 
        String username = sc.next();

        System.out.print("Enter Password : ");
        String password = sc.next();

        // UserName are unique values. only one record will retrieve.
        String query = "select user_password from logindata where username = '"+username+"'";
        // "select * from logindata"  is not optimized query

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empj2ee","root","Kunal@447");
            statement = connection.createStatement();

            rs = statement.executeQuery(query);

            // without using rs.next(), Exception occurs. Even if resultSet has only one row Still need to check
            while(rs.next()){
                String tempPass = rs.getString(1);

                if(tempPass.equals(password)){
                    System.out.println("Login Successfully");
                }else{
                    System.out.println("Invalid UserName or Password");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
