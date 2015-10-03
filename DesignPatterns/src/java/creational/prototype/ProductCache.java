package creational.prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sergei on 17.08.2015.
 */
public class ProductCache {
    private static Map<String, Product> productMap = new HashMap();

    public static Product getProduct(String productCode) {
        Product cachedProduct = productMap.get(productCode);
        return (Product) cachedProduct.clone();
    }

    public static void loadCache() {
        // for each product run expensive query and instantiate product
        // productMap.put(productKey, product);
        // for exemplification, we add only two products
        Book b1 = new Book();
        b1.setDescription("Oliver Twist");
        b1.setSKU("B1");
        b1.setNumberOfPages(100);
        productMap.put(b1.getSKU(), b1);
        DVD d1 = new DVD();
        d1.setDescription("Superman");
        d1.setSKU("D1");
        d1.setDuration(180);
        productMap.put(d1.getSKU(), d1);
    }
}
