package JdbcDemoApplication.Jdbc11_CollableStatement;

import java.sql.*;

public class Jdbc11_CollableStatement01 {

    private static Connection con;
    private static CallableStatement cstmt;
    private static ResultSet rs;

    public static void main(String[] args) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empj2ee","root","Kunal@447");
            cstmt = con.prepareCall("select addTwoNumbers(?,?)");

            cstmt.setInt(1,10);
            cstmt.setInt(2,20);

            rs = cstmt.executeQuery();

            if(rs.next())
            {
                System.out.println("ADDITION IS : "+rs.getInt(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
