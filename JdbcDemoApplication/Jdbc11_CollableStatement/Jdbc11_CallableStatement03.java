package JdbcDemoApplication.Jdbc11_CollableStatement;

import java.sql.*;

public class Jdbc11_CallableStatement03 {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empj2ee","root","Kunal@447");
            CallableStatement cstm = con.prepareCall("select studentGrade(?,?,?)");

            cstm.setInt(1,60);
            cstm.setInt(2,70);
            cstm.setInt(3,65);

            ResultSet rs = cstm.executeQuery();

            if(rs.next())
            {
                System.out.println("\n"+rs.getString(1));
            }
        } catch (
                SQLException e) {
            System.out.println(e);
        }
    }
}
