package _10_JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// To illustrate how we can update a database 
class _10_5_DbUpdate {
	public static void main(String[] args) throws SQLException {
		try (Connection connection = _10_3_DbConnector.connectToDb();
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet resultSet = statement.executeQuery("SELECT * FROM contact WHERE first_name=\"Michael\"")) {
			// first fetch the data and display it before the update operation 
			System.out.println("Before the update");
			JdbcUtil.printResultSet1(resultSet);

			// now update the resultSet and display the modified data 
			resultSet.absolute(1);
			resultSet.updateString("phone_no", "+919976543210");
			resultSet.updateRow();

			System.out.println("After the update");
			resultSet.beforeFirst();
			JdbcUtil.printResultSet1(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(-1); 
		}
	}
}
