package JdbcDemoApplication.Jdbc10_Pstmt_AddBatch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class Jdbc09_Pstmt_addBatch {
    public static void main(String[] args) {
      
        ArrayList<ProductDTO> productList=new ArrayList<>();
      
        productList.add(new ProductDTO(1,"X-BOX","GAMING",20,49999.99));
        productList.add(new ProductDTO(2,"PS-5","GAMING",20,54239.65));
        productList.add(new ProductDTO(3,"CONSOLE","GAMING",20,49999.99));
        productList.add(new ProductDTO(4,"CHARGER","ELECTRONICS",20,19999.99));
        productList.add(new ProductDTO(5,"CPU","ELECTRONICS",20,34223.45));

      
        Connection con;
        PreparedStatement pstmt;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empj2ee", "root", "Kunal@447");
          
            pstmt=con.prepareStatement("insert into productsimulation values (?,?,?,?,?)");//query to insert values inside the sql table.

            //for each loop used for getting the values from the arraylist and setting it to the pstmt query
            for (ProductDTO data:productList) /*arraylist name */
            {
                pstmt.setInt(1,data.getProductId());
                pstmt.setString(2, data.getProductName());
                pstmt.setString(3, data.getProductCategory());
                pstmt.setInt(4,data.getProductQty());
                pstmt.setDouble(5,data.getProductPrice());

                pstmt.addBatch();  //it will create batch

            }
          
            int [] count= pstmt.executeBatch();//method to execute batch at once;
          
            System.out.println(count.length+" record inserted successfully!");
          
            for(int i : count){
                System.out.println(i);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
