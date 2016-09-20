package logic;

import javax.servlet.http.HttpServletRequest;

public class RegistrationCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = ConfigurationManager.getProperty("path.page.registration"); 
		return page;
	}

}
