package JdbcDemoApplication.Jdbc04_Secured;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Jdbc03_Secured {

    private static Scanner scanner = new Scanner(System.in);
    private static Connection connection;
    // declare Connection reference as private to make secure.

    static{
        try{
            /*Load the JDBC driver by calling the Class. forName() method with the driver's class name as an argument.
            This step is optional for modern JDBC drivers, as they are automatically loaded by the DriverManager.*/
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empj2ee","root","Kunal@447");
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println("Started...!!!");
        operation();
    }

    public static void operation(){

        System.out.print("Enter ID : ");
        int empId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name : ");
        String empName = scanner.nextLine();

        System.out.print("Enter Dept : ");
        String empDept = scanner.nextLine();

        System.out.print("Enter Sal : ");
        double empSal = scanner.nextDouble();

        String query = "insert into emp1 values("+empId+",'"+empName+"','"+empDept+"',"+empSal+")";

        try {
            Statement statement = connection.createStatement();
            int count = statement.executeUpdate(query);

            if(count > 0){
                System.out.println(count + " Data Inserted Successfully 🎉🎉");
            }else{
                System.out.println("Data is Not Inserted");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
//            try {
//                connection.close();
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }

            /*
            * The Connection interface extends AutoCloseable in JDK 7 and after.
            * If you declare a connection in a try-with-resources statement and
            * there is an error that the code does not catch,
            * the JRE will attempt to close the connection automatically.
            * */

            System.out.println("Ending..!!!");
        }

    }
}
