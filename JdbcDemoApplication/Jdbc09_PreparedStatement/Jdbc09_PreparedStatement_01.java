package JdbcDemoApplication.Jdbc09_PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class Jdbc09_PreparedStatement_01 {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter Product Id :");
        int id= sc.nextInt();
        System.out.println("Enter Product name :");
        String name= sc.next();
        System.out.println("Enter product Category :");
        String category= sc.next();
        System.out.println("Enter product qty :");
        int qty= sc.nextInt();
        System.out.println("Enter Product Price : ");
        double price=sc.nextDouble();

        insertProductInformation(id,name,category,qty,price);
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private static void insertProductInformation(int id, String name, String category, int qty, double price) {
        Connection con=null;
        PreparedStatement pstmt=null;

        String query="insert into productsimulation values(?,?,?,?,?)";

        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/empj2ee","root","Kunal@447");
            pstmt=con.prepareStatement(query);

            pstmt.setInt(1,id);
            pstmt.setString(2,name);
            pstmt.setString(3,category);
            pstmt.setInt(4,qty);
            pstmt.setDouble(5,price);

            int count= pstmt.executeUpdate();
            System.out.println(count+" record inserted");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
