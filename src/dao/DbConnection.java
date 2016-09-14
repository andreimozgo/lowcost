package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	private static Connection myConnection;

	public static synchronized Connection getConnection() {

		if (myConnection == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException cnfe) {
				System.out.println("Error loading driver: " + cnfe);
			}
			String dbURL = "jdbc:mysql://localhost:3306/lowcost";
			String username = "root";
			String password = "1234";
			try {
				myConnection = DriverManager.getConnection(dbURL, username, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return myConnection;
	}
}
