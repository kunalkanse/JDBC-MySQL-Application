package JdbcDemoApplication.Jdbc13_storedProcedure;

import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbc13_RetrieveMultipleTable {
    public static void main(String[] args) {
        try {
            CallableStatement cstmt = DriverManager.getConnection("jdbc:mysql://localhost:3306/empj2ee","root","Kunal@447").prepareCall("{call RetrieveMultipleTableProcedure()}");

            ResultSet r1 = cstmt.executeQuery();

            while(r1.next()){
                System.out.println(r1.getInt(1)+"\t"+r1.getString(2)+"\t"+r1.getString(3)+"\t"+r1.getDouble(4));
            }

            if(cstmt.getMoreResults()){
                ResultSet r2 = cstmt.getResultSet();

                while(r2.next()){
                    System.out.println(r2.getInt(1)+"\t"+r2.getString(2)+"\t"+r2.getString(3)+"\t"+r2.getString(4)+"\t"+r2.getString(4));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
