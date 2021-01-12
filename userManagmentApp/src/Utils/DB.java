package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

	private static String jdbcURL = "jdbc:mysql://localhost:3306/userdb";
	private static String jdbcUsername = "root";
	private static String jdbcPassword = "root";
	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		} catch (ClassNotFoundException e)
		{	
			e.printStackTrace();
		}
		return connection;
	}
}
