
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/test")
@WebServlet(name = "HelloServlet", urlPatterns = {"/test"})
public class HelloServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3654876251516837609L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html"); // Задаем формат ответа - HTML
												
		PrintWriter out = response.getWriter(); // Получаем объект, позволяющий
		out.write("<!DOCTYPE html>\n"			// записать контент в ответ
				+	"<html>\n"
				+ "<h1>Hello servlet</h1>\n"
				+ "</body></html>");
	}
}