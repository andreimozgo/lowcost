package dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.w3c.dom.Entity;

public class ServicesDAO extends AbstractDAO {

	public ServicesDAO(Connection connection) {
		super(connection);
	}

	@Override
	public void findAll() {

		Statement statement;
		try {
			statement = connection.createStatement();
			String query = "SELECT services_id,name,cost FROM services";
			ResultSet result = statement.executeQuery(query);
			while (result.next()) {
				System.out.println(result.getString(1) + " " + result.getString(2) + " " + result.getString(3));
			}
			result.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
