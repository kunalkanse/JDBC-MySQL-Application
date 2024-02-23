package JdbcDemoApplication.Jdbc10_Pstmt_AddBatch;

public class ProductDTO {
    int productId;
    String productName;
    String productCategory;
    int productQty;
    double productPrice;

    public Product(int productId, String productName, String productCategory, int productQty, double productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productQty = productQty;
        this.productPrice = productPrice;
    }

    public Product() {

    }

    //////////////////////////////////////////////////////////////////////////////
    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public int getProductQty() {
        return productQty;
    }

    public double getProductPrice() {
        return productPrice;
    }

    ///////////////////////////////////////////////////////////////////////


    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public void setProductQty(int productQty) {
        this.productQty = productQty;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
}
