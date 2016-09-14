package dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.w3c.dom.Entity;

public class UsersDAO extends AbstractDAO {

	public UsersDAO(Connection connection) {
		super(connection);
	}

	@Override
	public void findAll() {

		Statement statement;
		try {
			statement = connection.createStatement();
			String query = "SELECT user_id,login FROM users";
			ResultSet result = statement.executeQuery(query);
			while (result.next()) {
				System.out.println(result.getString(1) + " " + result.getString(2));
			}
			result.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String getPassword (String login){
		Statement statement;
		String pass=null;
		try {
			statement = connection.createStatement();
			String query = "SELECT pass FROM users WHERE login=\""+login+"\"";
			ResultSet result = statement.executeQuery(query);
			result.next() ;
				pass = result.getString(1);
			result.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pass;
	}
	
	public String getUserRoleByLogin (String login){
		Statement statement;
		String role="user";
		try {
			statement = connection.createStatement();
			String query = "SELECT role FROM users WHERE login=\""+login+"\"";
			ResultSet result = statement.executeQuery(query);
			result.next() ;
				role = result.getString(1);
			result.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return role;
	}
}
