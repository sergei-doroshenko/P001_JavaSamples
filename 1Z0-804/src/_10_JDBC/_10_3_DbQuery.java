package _10_JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// Program to illustrate how to query a database 
class _10_3_DbQuery {
	public static void main(String[] args) {
		// Get connection, execute query, get the result set 
		// and print the entries from the result rest 
		try (Connection connection = _10_3_DbConnector.connectToDb();
			Statement statement = connection.createStatement(); 
			ResultSet resultSet = statement.executeQuery("SELECT * FROM contact") ){
			JdbcUtil.printResultSet2(resultSet);
		} 
		catch (SQLException sqle) {
			sqle.printStackTrace();
			System.exit(-1); 
		}
  	}
}