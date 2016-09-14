package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.Flight;

public class FlightDAO extends AbstractDAO {
	public static final String SELECT_ALL_FLIGHT = "SELECT * FROM flight";

	public FlightDAO(Connection connection) {
		super(connection);
	}

	@Override
	public void findAll() {
		Statement statement;
		try {
			statement = connection.createStatement();
			String query = "SELECT flight_id,date,seats,cost,up_cost FROM flight";
			ResultSet result = statement.executeQuery(query);
			while (result.next()) {
				System.out.println(result.getString(1) + " " + result.getString(2) + " " + result.getString(3) + " "
						+ result.getString(4) + " " + result.getString(5));
			}
			result.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Flight> getAll() {

		List<Flight> lst = new ArrayList<>();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(SELECT_ALL_FLIGHT);
			try {
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Flight flight = new Flight(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4),
							rs.getByte(5));
					lst.add(flight);
				}
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				ps.close();
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return lst;

	}
}
