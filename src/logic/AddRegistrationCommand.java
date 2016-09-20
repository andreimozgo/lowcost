package logic;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;


import dao.DataSource;
import dao.FlightDAO;
import dao.UsersDAO;
import dto.User;

public class AddRegistrationCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		
		String page = null;
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		User user = new User(login, password);
		
		try {
			Connection connectionDb = DataSource.getInstance().getConnection();
			UsersDAO usersDao = new UsersDAO(connectionDb);
			if (usersDao.create(user)){
				page = ConfigurationManager.getProperty("path.page.login");
			}
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
