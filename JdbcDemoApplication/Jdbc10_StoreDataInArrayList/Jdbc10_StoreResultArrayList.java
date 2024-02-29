package JdbcDemoApplication.Jdbc10_StoreDataInArrayList;
import JdbcDemoApplication.Jdbc10_Pstmt_AddBatch.Product;
import java.sql.*;
import java.util.ArrayList;

public class Jdbc10_StoreResultArrayList {
    public static void main(String[] args) {
        Connection con;
        PreparedStatement pstmt;
        ResultSet rs;
        ArrayList<Product> productlist=new ArrayList<>();

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/empj2ee","root","Kunal@447");
            pstmt=con.prepareStatement("select * from productsimulation");
            rs=pstmt.executeQuery();

            Product p1;

            while (rs.next()){
                p1=new Product();

                p1.setProductId(rs.getInt(1));
                p1.setProductName(rs.getString(2));
                p1.setProductCategory(rs.getString(3));
                p1.setProductQty(rs.getInt(4));
                p1.setProductPrice(rs.getDouble(5));

                productlist.add(p1);
            }
            for (Product p:productlist){
                System.out.println(p.getProductName());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
