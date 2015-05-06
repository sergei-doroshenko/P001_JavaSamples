package sd.dao;

import sd.domain.Product;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergei on 06.05.2015.
 */
public class ProductDaoJDBCImpl implements ProductDao {

    private DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Product> findAll() {
        List<Product> result = new ArrayList<>();

        try (
                Connection connetion = dataSource.getConnection();
                Statement st = connetion.createStatement()
        ) {
            ResultSet rs = st.executeQuery("select * from playground.products;");
            while (rs.next()) {
                long id = rs.getLong("id");
                String prodName = rs.getString("prod_name");
                result.add(new Product(id, prodName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public Product findById(long id) {
        return null;
    }
}
