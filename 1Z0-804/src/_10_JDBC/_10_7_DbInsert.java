package _10_JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// To illustrate how to insert a row in a ResultSet and in the database 
public class _10_7_DbInsert {
	public static void main(String[] args) throws SQLException {
		try (Connection connection = _10_3_DbConnector.connectToDb();
Statement statement = connection.createStatement(
ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet resultSet = statement.executeQuery("SELECT * FROM contact")) {
		System.out.println("Before the insert");
		JdbcUtil.printResultSet1(resultSet);

		resultSet.moveToInsertRow();
		resultSet.updateString("first_name", "John");
		resultSet.updateString("last_name", "K.");
		resultSet.updateString("email", "john@abc.com");
		resultSet.updateString("phone_no", "+19753186420");
		resultSet.insertRow();

		System.out.println("After the insert");
		resultSet.beforeFirst();
// 		resultSet.relative(-1);
		JdbcUtil.printResultSet1(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

