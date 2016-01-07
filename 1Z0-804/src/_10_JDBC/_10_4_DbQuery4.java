package _10_JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class _10_4_DbQuery4 {
	public static void main(String[] args) throws SQLException {
		try (Connection connection = _10_3_DbConnector.connectToDb();
			Statement statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery("SELECT first_name, email FROM contact WHERE first_name=\"Michael\"")) {
			System.out.println("fName \temail");
			while (resultset.next()){
				System.out.println(resultset.getString("first_name") + "\t"
					+ resultset.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(-1); 
		}
	}
}
