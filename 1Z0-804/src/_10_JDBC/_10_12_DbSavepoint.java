package _10_JDBC;

import java.sql.*;

// To illustrate how to use savepoints with commits and rollbacks 
public class _10_12_DbSavepoint {
	public static void main(String[] args) throws SQLException {
		Connection connection = _10_3_DbConnector.connectToDb();
		ResultSet resultSet = null;
		// we're using explicit finally blocks 
		// instead of try-with-resources statement in this code 
		try {
			// for commit/rollback we first need to set auto-commit to false 
			connection.setAutoCommit(false);
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			resultSet = statement.executeQuery("SELECT * FROM family_group");
			System.out.println("Printing the contents of the table before inserting");
			while(resultSet.next()) {
				System.out.println(resultSet.getInt("id") + " " + resultSet.getString("nick_name"));
			}
			System.out.println("Starting to insert rows"); 
			// first insert 
			resultSet.moveToInsertRow();
			resultSet.updateString("nick_name", "Tom");
			resultSet.insertRow();
			System.out.println("Inserted row for Tom");
			// our first savepoint is here... 
			Savepoint firstSavepoint = connection.setSavepoint(); 
						
			// second insert 
			resultSet.moveToInsertRow();
			resultSet.updateString("nick_name", "Dick");
			resultSet.insertRow();
			System.out.println("Inserted row for Dick");
			// our second savepoint is here... after we inserted Dick 
			// we can give a string name for savepoint 
			Savepoint secondSavepoint = connection.setSavepoint("SavepointForDick"); 
			
			// third insert 
			resultSet.moveToInsertRow();
			resultSet.updateString("nick_name", "Harry");
			resultSet.insertRow();
			System.out.println("Inserted row for Harry");
			// our third savepoint is here... for "Harry"
			Savepoint thirdSavepoint = connection.setSavepoint("ForHarry"); 
			System.out.println("Table update complete...");
			
			// rollback to the state when Dick was inserted; 
			// so the insert for Harry will be lost 
			System.out.println("Rolling back to the state where Tom and Dick were inserted, but Harry is not.");
			connection.rollback(secondSavepoint); 
			// commit the changes now and see what happens to the contents of the table 
			connection.commit();

			resultSet = statement.executeQuery("SELECT * FROM family_group");
			System.out.println("Printing the contents of the table after commit");
			while(resultSet.next()) {
				System.out.println(resultSet.getInt("id") + " " + resultSet.getString("nick_name"));
			}
		} catch (SQLException e) {
			System.out.println("Something gone wrong, couldn't add a contact in family group");
			// roll back all the changes in the transaction since something has gone wrong 
			connection.rollback();
			e.printStackTrace();
		} finally {
			if(connection != null) connection.close();
			if(resultSet != null) resultSet.close();
		}
	}
}
