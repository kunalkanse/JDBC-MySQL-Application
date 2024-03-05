package JdbcDemoApplication.Jdbc12_CollableStatement;

import java.sql.*;

public class Jdbc12_CollableStatement {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empj2ee","root","Kunal@447");

            // Another Way of the calling stored function
            CallableStatement cstm = con.prepareCall("{?=call addTwoNumbers(?,?)}");

            cstm.registerOutParameter(1, Types.INTEGER);
            cstm.setInt(2,10);
            cstm.setInt(3,20);

            ResultSet rs = cstm.executeQuery();

            if(rs.next())
            {
                System.out.println("ADDITION IS : "+rs.getInt(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
