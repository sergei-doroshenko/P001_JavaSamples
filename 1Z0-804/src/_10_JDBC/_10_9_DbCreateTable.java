package _10_JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
class _10_9_DbCreateTable {
	public static void main(String[] args) {
		String sql = "CREATE TABLE family_group (id int not null auto_increment, nick_name varchar(30) not null, primary key(id));";
		try (Connection connection = _10_3_DbConnector.connectToDb();
			Statement statement = connection.createStatement()){ 
			// use CREATE TABLE SQL statement to create table familyGroup
			int result = statement.executeUpdate(sql);
			System.out.println("Table created successfully");
		} 
		catch (SQLException sqle) {
			sqle.printStackTrace();
			System.exit(-1); 
		}
  	}
}
