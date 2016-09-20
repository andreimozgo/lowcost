package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import dto.Entity;

public abstract class AbstractDAO<T extends Entity> {

	protected Connection connection;

	public AbstractDAO(Connection connection) {
		this.connection = connection;
	}

	public abstract List<T> getAll();

	public void close(Statement st) {
		try {
			if (st != null) {
				st.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
