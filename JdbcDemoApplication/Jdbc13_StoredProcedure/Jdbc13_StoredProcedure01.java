package JdbcDemoApplication.Jdbc13_StoredProcedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Jdbc13_StoredProcedure01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("ENTER EMPLOYEE ID :");
        int empId = scanner.nextInt(); 

        System.out.println("ENTER EMPLOYEE NAME : ");
        String empName = scanner.next();

        System.out.println("ENTER EMPLOYEE DEPARTMENT : ");
        String empDept = scanner.next();

        System.out.println("ENTER EMPLOYEE SALARY : ");
        double empSal = scanner.nextDouble();

        System.out.println("ENTER USER NAME : ");
        String uName = scanner.next();

        System.out.println("ENTER USER EMAIL : ");
        String uEmail = scanner.next();

        System.out.println("ENTER USER MOBILE NO. : ");
        String uNo = scanner.next();

        System.out.println("ENTER USER PASSWORD : ");
        String uPass = scanner.next();

        try {
            CallableStatement cstmt = DriverManager.getConnection("jdbc:mysql://localhost:3306/empj2ee", "root", "Kunal@447").prepareCall("{ call empProcedure(?,?,?,?,?,?,?,?)}");
            cstmt.setInt(1,empId);
            cstmt.setString(2,empName);
            cstmt.setString(3,empDept);
            cstmt.setDouble(4,empSal);

            cstmt.setString(5,uName);
            cstmt.setString(6,uEmail);
            cstmt.setString(7,uNo);
            cstmt.setString(8,uPass);

            int count = cstmt.executeUpdate();
            System.out.println(count + "RECORD INSERTED");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
