package sd.domain;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Sergei on 30.04.2015.
 */
public class Order implements Serializable {
    static final long serialVersionUID = 1L;
    private String orderNo;
    private String productName;
    private BigDecimal price;
    private int qty;
    private boolean edited;
    private boolean selected;

    public Order() {
    }

    public Order(String orderNo, String productName,
                 BigDecimal price, int qty) {
        this.orderNo = orderNo;
        this.productName = productName;
        this.price = price;
        this.qty = qty;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public boolean isEdited() {
        return edited;
    }

    public void setEdited(boolean edited) {
        this.edited = edited;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
