package logic;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.DataSource;
import dao.NewsDAO;
import dto.News;

public class LoginCommand implements ActionCommand {
	private static final String PARAM_NAME_LOGIN = "login";
	private static final String PARAM_NAME_PASSWORD = "password";

	@Override
	public String execute(HttpServletRequest request) {

		String page = null;
		try {
			Connection connectionDb = DataSource.getInstance().getConnection();
			// извлечение из запроса логина и пароля
			String login = request.getParameter(PARAM_NAME_LOGIN);
			String pass = request.getParameter(PARAM_NAME_PASSWORD);
			// проверка логина и пароля
			if (LoginLogic.checkLogin(login, pass, connectionDb)) {
<<<<<<< HEAD
				HttpSession session = request.getSession(true);
				session.setAttribute("user", login);
				// получение роли пользователя
				String userRole = LoginLogic.getUserRole(login, connectionDb);
				// помещение роли в сессию
				session.setAttribute("role", userRole);
=======
				request.setAttribute("user", login);
>>>>>>> branch 'master' of https://github.com/andreimozgo/lowcost.git
				// определение пути к main.jsp
<<<<<<< HEAD
				if (userRole.equals("admin")) {
					page = ConfigurationManager.getProperty("path.page.main");
				} else {
					page = ConfigurationManager.getProperty("path.page.user");
				}

				FlightDAO fd = new FlightDAO(connectionDb);
				List<Flight> flights = fd.getAll();
				request.setAttribute("flights", flights);
=======
				page = ConfigurationManager.getProperty("path.page.main");
				NewsDAO newsDao = new NewsDAO(connectionDb);
				List<News> news = newsDao.getAll();
				request.setAttribute("news", news);
>>>>>>> branch 'master' of https://github.com/andreimozgo/lowcost.git
				try {
					connectionDb.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				request.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.loginerror"));
				page = ConfigurationManager.getProperty("path.page.login");
			}

		} catch (SQLException e2) {
			e2.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		} catch (PropertyVetoException e2) {
			e2.printStackTrace();
		}
		return page;
	}
}
