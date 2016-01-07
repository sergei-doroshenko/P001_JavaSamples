package _10_JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Sergei on 07.01.2016.
 */
public class JdbcUtil {
    public static void printResultSet1(ResultSet resultSet) throws SQLException {
        System.out.println("ID \tfName \tlName \temail \t\tphoneNo");
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("id") + "\t"
                    + resultSet.getString("first_name") + "\t"
                    + resultSet.getString("last_name") + "\t"
                    + resultSet.getString("email") + "\t"
                    + resultSet.getString("phone_no"));
        }
    }

    public static void printResultSet2(ResultSet resultSet) throws SQLException {
        int columCount = resultSet.getMetaData().getColumnCount();
        while (resultSet.next()) {
            for (int i = 1; i <= columCount; i++) {
                System.out.print(resultSet.getObject(i) + "\t");
            }
            System.out.println("");
        }
    }
}
