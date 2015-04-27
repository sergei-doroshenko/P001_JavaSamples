package sd.dao;

import sd.domain.Product;

import java.util.List;

/**
 * Created by Sergei on 27.04.2015.
 */
public interface ProductDao {
    List<Product> findAll();

    Product findById(long id);
}
