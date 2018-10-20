package pl.javaee.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/about")
public class AboutServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body><h1>O mnie:</h1>"
				+ "<h3>Cześć.</br>Mam na imię Karol. Jestem studentem III roku Informatyki, na specjalności: aplikacje internetowe i bazy danych.</br>Pozdrawiam.</h3>"
				+ "</body></html>");
		out.close();
	}
}
