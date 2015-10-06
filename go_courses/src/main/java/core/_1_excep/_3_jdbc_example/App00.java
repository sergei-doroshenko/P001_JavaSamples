package core._1_excep._3_jdbc_example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Sergei on 26.02.2015.
 */
public class App00 {
    public static void main(String[] args) throws Throwable {

        Connection conneection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Throwable t0 = null;
        try {

            conneection = DriverManager.getConnection("");
            preparedStatement = conneection.prepareStatement("");
            resultSet = preparedStatement.executeQuery();

        } catch (Throwable t) {
            t0 = t;
        } finally {
            Throwable t1 = null;
            try {
                if(resultSet != null) {
                    resultSet.close();
                }
            } catch (Throwable t) {
                t1 = t;
            }

            try {
                if(preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (Throwable t) { t1 = t;}

            try {
                if(conneection != null) {
                    conneection.close();
                }
            } catch (Throwable t) { t1 = t; }

            if (t0 != null) {
                throw t0;
            }

            if (t1 != null) {
                throw t1;
            }
        }

    }
}
