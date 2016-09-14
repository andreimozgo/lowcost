package jsp;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jsp/inputaction")
public class NameServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4566085037356047885L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		request.setAttribute("fio", request.getParameter("fio"));
		request.setAttribute("phone", request.getParameter("phone"));
		request.setAttribute("mail", request.getParameter("mail"));
		if (request.getParameter("fio").equals("")) {
			request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
		}
		else request.getRequestDispatcher("/jsp/result.jsp").forward(request, response);
	}
}
