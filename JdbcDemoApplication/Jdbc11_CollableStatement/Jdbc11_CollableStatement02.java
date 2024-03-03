package JdbcDemoApplication.Jdbc12_CollableStatement;

import java.sql.*;

public class Jdbc12_CollableStatement02 {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empj2ee","root","Kunal@447");
            CallableStatement cstm = con.prepareCall("select checkEvenOdd(?)");

            cstm.setInt(1,4);
            ResultSet rs = cstm.executeQuery();

            if(rs.next())
            {
                System.out.println("NUMBER IS "+rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
