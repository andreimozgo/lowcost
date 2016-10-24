package logic;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dao.DataSource;
import dao.Flight;
import dao.FlightDAO;

public class DeleteFlightCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("flight_id"));
		FlightDAO flightDao;
		Connection connection;
		String page = null;
		try {
			connection = DataSource.getInstance().getConnection();
			flightDao = new FlightDAO(connection);
			flightDao.delete(id);
			page = ConfigurationManager.getProperty("path.page.main");
			List<Flight> flights = flightDao.getAll();
			request.setAttribute("flights", flights);
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		return page;
	}
}
