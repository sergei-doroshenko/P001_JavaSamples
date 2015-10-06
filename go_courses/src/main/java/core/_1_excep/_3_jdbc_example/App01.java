package core._1_excep._3_jdbc_example;

import java.sql.*;

/**
 * Created by Sergei on 26.02.2015.
 */
public class App01 {
    public static void main(String[] args) throws SQLException {

        try (Connection conneection = DriverManager.getConnection("");
             PreparedStatement preparedStatement = conneection.prepareStatement("");
             ResultSet resultSet = preparedStatement.executeQuery()
        ) {

        }
    }





}
