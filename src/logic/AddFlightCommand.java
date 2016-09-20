package logic;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dao.DataSource;
import dao.FlightDAO;
import dto.Flight;

public class AddFlightCommand implements ActionCommand {
	private FlightDAO flightDao;
	
	public AddFlightCommand (){
		Connection connection;
		try {
			connection = DataSource.getInstance().getConnection();
			flightDao = new FlightDAO(connection);
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String execute(HttpServletRequest request) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		  String startDateString = request.getParameter("flightDate");
		  LocalDate date = LocalDate.parse(startDateString, formatter);
		  int seats = Integer.parseInt(request.getParameter("seats"));
		  int cost = Integer.parseInt(request.getParameter("cost"));
		  int upCost = Integer.parseInt(request.getParameter("upCost"));
		  
		  flightDao.addFlight(date, seats, cost, upCost);
		  String page = ConfigurationManager.getProperty("path.page.main");
		  
			List<Flight> flights =  flightDao.getAll();
			request.setAttribute("flights", flights);
		  
		  
		return page;
	}

}
