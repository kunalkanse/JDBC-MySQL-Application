package JdbcDemoApplication.Jdbc05_BoilerMain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

// This class is extending the class which contains common statements which are required in every JDBC Application
// Jdbc05_Boilerplate is the generalized class which contains general code

public class Jdbc04_BoilerMain extends Jdbc05_Boilerplate {
    public static void main(String[] args) {
        operation();
    }

    public static void operation(){
        Jdbc04_BoilerMain boiler = new Jdbc04_BoilerMain();
        ArrayList<String> data = new ArrayList<>();

        boiler.setConnection();
        Statement statement = boiler.getStatement();    // getting from Generalized class which is super class
        // we can call it directly by declaring it static

        if (statement != null){
            System.out.println("Connection Successfully Established");

            System.out.print("Enter Employee ID : ");
            int id = new Scanner(System.in).nextInt();
            String query = " SELECT emp_name,emp_sal FROM emp1 WHERE emp_id = "+id;

            try{
                ResultSet rs = statement.executeQuery(query);

                System.out.println("\nName\t\tSalary");
                while (rs.next()){
                    String s = rs.getString("emp_name")+"\t"+rs.getString("emp_sal");
                    data.add(s);
                }

                for (String row : data) {
                    System.out.println(row);
                }
            }catch (SQLException | NullPointerException e){
                System.out.println(e);
            }
        }


    }
}
