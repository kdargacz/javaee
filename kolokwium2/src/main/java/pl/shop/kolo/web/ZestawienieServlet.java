package pl.shop.kolo.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.shop.kolo.service.StorageService;
import pl.shop.kolo.domain.Card;

@WebServlet("/showAll")
public class ZestawienieServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// TODO Auto-generated method stub

		response.setContentType("text/html;charset=UTF-8");

		// pobranie z kontekstu aplikacji interfejsu Map
		ServletContext servletContext = getServletContext();
		StorageService storage = (StorageService) servletContext.getAttribute("storageC");
		Map<String, Card> db = storage.getAllcards();

		PrintWriter out = response.getWriter();

		// wyświetlenie wszystkich elementów z interfejsu Map
		out.println("<html><body>");
		
		Set<Map.Entry<String,Card>> xSet = db.entrySet();
		for(Map.Entry<String,Card> x: xSet) {
		out.println(x.getKey() + " " + x.getValue().getProdukcja() + " " + x.getValue().getCena() + " " + x.getValue().getProducent() + " " + x.getValue().getQty() + " ");
		for (String s: x.getValue().getKolory()) {
			out.println(s + " ");
		}
		out.println("<br>");
		
		}		
		out.println("</body></html>");
out.close();
	}
}
