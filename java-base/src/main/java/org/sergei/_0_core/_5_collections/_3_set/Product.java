package org.sergei._0_core._5_collections._3_set;

/**
 * Created by Sergei on 05.05.2015.
 */
public class Product {
    private final long id;
    private final String name;

    public Product(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        /*if (id != product.id) return false;
        return !(name != null ? !name.equals(product.name) : product.name != null);*/

        return id == product.id;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        /*result = 31 * result + (name != null ? name.hashCode() : 0);*/
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
