package sd.faces;

import sd.domain.Order;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sergei on 30.04.2015.
 */
@ManagedBean(name="order")
@SessionScoped
public class OrderBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Order> orderList;
    private String orderNo;
    private String productName;
    private BigDecimal price;
    private int qty;
    private Order selected;

    {
        orderList = new ArrayList<Order>();
        orderList.add(new Order("A0001", "Intel CPU", new BigDecimal("700.00"), 1));
        orderList.add(new Order("A0002", "Harddisk 10TB", new BigDecimal("500.00"), 2));
        orderList.add(new Order("A0003", "Dell Laptop", new BigDecimal("11600.00"), 8));
        orderList.add(new Order("A0004", "Samsung LCD", new BigDecimal("5200.00"), 3));
        orderList.add(new Order("A0005", "A4Tech Mouse", new BigDecimal("100.00"), 10));

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public Order getSelected() {
        return selected;
    }

    public void setSelected(Order selected) {
        this.selected = selected;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public String addAction() {
        Order order = new Order();
        order.setEdited(true);
        setSelected(order);
        orderList.add(order);
        return null;
    }

    public String editAction(Order order) {
        order.setEdited(true);
        setSelected(order);
        this.orderNo = order.getOrderNo();
        this.productName = order.getProductName();
        this.price = order.getPrice();
        this.qty = order.getQty();
        return null;
    }

    public String saveAction() {
        getSelected().setOrderNo(this.orderNo);
        getSelected().setProductName(this.productName);
        getSelected().setPrice(this.price);
        getSelected().setQty(this.qty);

        getSelected().setEdited(false);
        setSelected(null);
        clear();

        return null;
    }

    public String deleteAction(Order order) {
        orderList.remove(order);
        return null;
    }
    public String clear() {
        this.orderNo = "";
        this.productName = "";
        this.price = null;
        this.qty = 0;
        return null;
    }


}
