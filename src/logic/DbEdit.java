package logic;

import java.beans.PropertyVetoException;
import java.util.List;
import java.util.ResourceBundle;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.DataSource;
import dao.FlightDAO;
import dao.ServicesDAO;
import dao.TicketDAO;
import dao.UsersDAO;
import dto.Flight;

public class DbEdit {

	public static void main(String[] args) {

		Connection myConnection = null;

		try {
			myConnection = DataSource.getInstance().getConnection();
		} catch (SQLException | IOException | PropertyVetoException e1) {
			e1.printStackTrace();
		}
		try {
			myConnection.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		FlightDAO fd = new FlightDAO(myConnection);
		TicketDAO td = new TicketDAO(myConnection);
		ServicesDAO sd = new ServicesDAO(myConnection);
		UsersDAO ud = new UsersDAO(myConnection);

		fd.findAll();
		td.findAll();
		sd.findAll();
		ud.findAll();
		List<Flight> lst = fd.getAll();

		try {
			myConnection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			myConnection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
