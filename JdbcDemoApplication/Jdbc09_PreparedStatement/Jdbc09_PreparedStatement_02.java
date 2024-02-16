package JdbcDemoApplication.Jdbc09_PreparedStatement;

import java.util.Scanner;
import java.sql.*;

public class Pstmt02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter id ");
        int id= sc.nextInt();

        System.out.println("enter percentage to incr");
        double pecr= sc.nextDouble();

        incr(id,pecr);
    }

    private static void incr(int id, double pecr) {
        Connection con= null;
        PreparedStatement pstmt=null;
        String s1="update productsimulation set product_price=product_price+product_price*(?/100) where product_id=?";
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empj2ee","root","Kunal@447");
            pstmt=con.prepareStatement(s1);

            pstmt.setDouble(1,pecr);
            pstmt.setInt(2,id);

            int count=pstmt.executeUpdate();
            System.out.println(count+" record updated");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
