package sd.domain;

/**
 * Created by Sergei on 27.04.2015.
 */
public class Product {
    private long id;
    private String prodName;

    public Product() {
    }

    public Product(long id, String prodName) {
        this.id = id;
        this.prodName = prodName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }
}
