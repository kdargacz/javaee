package pl.shop.kolo.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.shop.kolo.domain.Card;
import pl.shop.kolo.service.StorageService;


@WebServlet("/shop")
public class ShopServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// pobranie z kontekstu aplikacji interfejsu Map
		ServletContext servletContext = getServletContext();
		StorageService storage = (StorageService) servletContext.getAttribute("storageC");
		Map<String, Card> db = storage.getAllcards();

		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();

		// wyświetlenie wszystkich elementów z interfejsu Map z opcją dodania do
		// koszyka
		out.println("<html><head></head><body>"
				+"<form action='basket' method='post'><input type='submit' value='Koszyk' /></th></tr>");
		for (String x : db.keySet()) {
			out.println("<tr>");
			out.println("<td>" + db.get(x).getName() + "</td>");
			if (db.get(x).isLeafy())
				out.println("<td>Liściaste</td>");
			else
				out.println("<td>Iglaste</td>");

			LocalDate localDate = db.get(x).getDataSiewu().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			int year = localDate.getYear();
			int month = localDate.getMonthValue();
			int day = localDate.getDayOfMonth();

			out.println("<td>" + day + " " + miesiac(month) + " " + year + "</td>");
			out.println("<td>" + db.get(x).getCena() + "</td>");
			out.println("<td><button type='submit' value='" + x + "' name='add'>Dodaj</button></td>");
			out.println("</tr>");
		}
		out.println("</form></table></body></html>");

		out.close();
}
	
	
}
