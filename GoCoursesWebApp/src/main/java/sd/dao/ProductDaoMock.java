package sd.dao;

import sd.domain.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergei on 27.04.2015.
 */
public class ProductDaoMock implements ProductDao {

    public List<Product> findAll() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1, "Apple"));
        products.add(new Product(2, "IBM"));
        products.add(new Product(3, "Gigabit"));
        return products;
    }

    public Product findById(long id) {
        return new Product(10, "Book");
    }
}
