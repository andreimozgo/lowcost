package logic;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.DataSource;
import dao.FlightDAO;
import dao.TicketDAO;
import dao.UsersDAO;
import dto.Flight;
import dto.Ticket;
import dto.User;

public class BuyTicketCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		HttpSession session = request.getSession(true);
		int flightId = Integer.parseInt(request.getParameter("flight_id"));
		int userId = (int) session.getAttribute("userid");

		try {
			Connection connectionDb = DataSource.getInstance().getConnection();
			FlightDAO flightDao = new FlightDAO(connectionDb);
			Flight flight = flightDao.findEntityById(flightId);
			int cost = flight.getCost();
			
			Ticket ticket = new Ticket(0,flightId,userId,cost, 0);
			TicketDAO ticketDao = new TicketDAO(connectionDb);
			if (ticketDao.create(ticket)){
				page = ConfigurationManager.getProperty("path.page.user");
			}

			List<Ticket> tickets = ticketDao.getAllByUser(userId);
			request.setAttribute("tickets", tickets);
			
			FlightDAO fd = new FlightDAO(connectionDb);
			List<Flight> flights = fd.getAll();
			request.setAttribute("flights", flights);
			
			try {
				connectionDb.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
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

		
		return page;
	}

}
