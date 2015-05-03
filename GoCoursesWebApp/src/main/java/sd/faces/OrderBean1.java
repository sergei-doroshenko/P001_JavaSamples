package sd.faces;

import sd.domain.Order;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergei on 30.04.2015.
 */
@ManagedBean(name="order1")
@SessionScoped
public class OrderBean1 implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Order> orderList;

    {
        orderList = new ArrayList<Order>();
        orderList.add(new Order("A0001", "Intel CPU", new BigDecimal("700.00"), 1));
        orderList.add(new Order("A0002", "Harddisk 10TB", new BigDecimal("500.00"), 2));
        orderList.add(new Order("A0003", "Dell Laptop", new BigDecimal("11600.00"), 8));
        orderList.add(new Order("A0004", "Samsung LCD", new BigDecimal("5200.00"), 3));
        orderList.add(new Order("A0005", "A4Tech Mouse", new BigDecimal("100.00"), 10));

    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public String addAction() {
        Order order = new Order();
        order.setSelected(true);
        order.setEdited(true);
        orderList.add(order);
        return null;
    }

    public String editAction(Order order) {
        order.setEdited(true);
        order.setSelected(true);
        return null;
    }

    public String saveAction(Order order) {
        order.setSelected(false);
        return null;
    }

    public String deleteAction(Order order) {
        orderList.remove(order);
        return null;
    }
}
