package _10_JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// To illustrate how to delete a row in a ResultSet and in the database 
class _10_8_DbDelete {
	public static void main(String[] args) throws SQLException {
		try (Connection connection = _10_3_DbConnector.connectToDb();
			 Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			 ResultSet resultSet1 = statement.executeQuery("SELECT * FROM contact WHERE first_name=\"John\"")) {
			if(resultSet1.next()){
				// delete the first row
				resultSet1.deleteRow();
			}
			resultSet1.close();
				
			// now fetch again from the database
			try (ResultSet resultSet2 = statement.executeQuery("SELECT * FROM contact")) {
				System.out.println("After the deletion");
				JdbcUtil.printResultSet1(resultSet2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(-1); 
		}
	}
}