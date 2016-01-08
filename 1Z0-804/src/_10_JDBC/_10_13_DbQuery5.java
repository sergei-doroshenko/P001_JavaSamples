package _10_JDBC;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.SQLException;

// To illustrate how to use RowSet, RowSetProvider, and RowSetFactory  
class _10_13_DbQuery5 {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/addressBook";
		String userName = "root"; 
		String password = "mysql123";
		try {
			// first, create a factory object for rowset 
			RowSetFactory rowSetFactory = RowSetProvider.newFactory();
			// create a JDBC rowset from the factory 
			JdbcRowSet rowSet = rowSetFactory.createJdbcRowSet();
			rowSet.setUrl(url);
			rowSet.setUsername(userName);                               
			rowSet.setPassword(password);                               
			rowSet.setCommand("SELECT * FROM contact");
			rowSet.execute(); 
			JdbcUtil.printResultSet1(rowSet);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
}
