package JdbcDemoApplication.Jdbc03_DisplayData;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Jdbc03_DisplayData {
    public static void main(String[] args) {

        ArrayList empDetails = new ArrayList(); // To store Data

        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        String query = "select * from emp1";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            statement = DriverManager.getConnection("jdbc:mysql://localhost/empj2ee","root","Kunal@447").createStatement();
            // statement = connection.createStatement();    // performed directly in above step by METHOD CHAINING
            rs = statement.executeQuery(query);

            System.out.println("__________________________________");
            System.out.println("ID\tName\tDepartment\tSalary");
            System.out.println("----------------------------------");

            while(rs.next()){
                //System.out.println(rs.getInt("emp_Id") + "\t" + rs.getString("emp_Name") + "\t" + rs.getString("emp_Dept") + "\t" + rs.getDouble("emp_Sal"));
                String data = (rs.getInt("emp_Id") + "\t" + rs.getString("emp_Name") + "\t" + rs.getString("emp_Dept") + "\t" + rs.getDouble("emp_Sal"));

                empDetails.add(data);   // add in ARRAYLIST
            }

            System.out.println();

            // Display ArrayList Data
            Iterator iObj = empDetails.iterator();
            while (iObj.hasNext()){
                System.out.println(iObj.next());
            }

        } catch(ClassNotFoundException e){
            throw new RuntimeException(e);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        finally {
//            try{
//                connection.close();
//            }catch(SQLException e){
//                throw new RuntimeException(e);
//            }
            // No need to close cause we haven't used connection.
            // directly returned Statement object by using getConnection().createStatement()
        }
    }
}
