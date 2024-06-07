package LibraryApps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnectionDemo {
	static final String DB_URL = "jdbc:mysql://localhost:3306/librarydb";
	static final String DB_USER = "root";
	static final String DB_PASSWORD = "root";
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	}


}
