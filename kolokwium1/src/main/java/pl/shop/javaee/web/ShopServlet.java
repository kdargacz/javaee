package pl.shop.javaee.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pl.shop.javaee.domain.Rodo;
import pl.shop.javaee.domain.Tree;
import pl.shop.javaee.service.StorageService;

@WebServlet("/shop")
public class ShopServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// metoda zamieniająca wartość liczbową na polską nazwę miesiąca
	public String miesiac(int i) {
		String[] tab = { "Styczeń", "Luty", "Marzec", "Kwiecień", "Maj", "Czerwiec", "Lipiec", "Sierpień", "Wrzesień",
				"Październik", "Listopad", "Grudzień" };
		return tab[--i];
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		//pobranie atrybutu ciasteczek z sesji
		HttpSession httpSessionCookies = request.getSession();
		if (request.getParameter("zgoda1") != null) {
			boolean zgoda1 = Boolean.parseBoolean(request.getParameter("zgoda1"));
			Rodo rodoIn = (Rodo) httpSessionCookies.getAttribute("rodo");
			Rodo rodoOut = new Rodo(zgoda1,rodoIn.isZgoda2(),rodoIn.isZgoda3());
			httpSessionCookies.setAttribute("rodo", rodoOut);
		}
		//odczyt z sesji zgody na ciasteczka
		Rodo rodo = (Rodo) httpSessionCookies.getAttribute("rodo");
		
		
		
		// pobranie z kontekstu aplikacji interfejsu Map
		ServletContext servletContext = getServletContext();
		StorageService storage = (StorageService) servletContext.getAttribute("storage");
		Map<String, Tree> db = storage.getAllTrees();

		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();

		// wyświetlenie wszystkich elementów z interfejsu Map z opcją dodania do
		// koszyka
		out.println("<html><head><link rel='stylesheet' type='text/css' href='" + request.getContextPath()
				+ "/assets/css/style.css' />"
				+ "<link rel='stylesheet' type='text/css' href='" + request.getContextPath() +"/assets/css/cookie.css' />"
				+ "</head><body>"
				+ "<div id='cookieConsent'>Ta strona używa ciasteczek. Żeby kontynuować korzystanie ze sklepu trzeba wyrazić "
				+ "zgodę na ich użycie. <form><button type='submit' value='true' name='zgoda1'>Wyrażam zgodę</button></form>"
				+ "<a href='https://pl.wikipedia.org/wiki/HTTP_cookie' target='_blank'>Więcej informacji</a>.</div>"
				+"<h1>Sklep ogrodniczy z drzewami</h1>"
				+ "<table><tr><th>Nazwa</th><th>Rodzaj</th><th>Data siewu</th><th>Cena</th>"
				+ "<th><form action='basket' method='post'><input type='submit' value='Koszyk' /></th></tr>");
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
		String display = "initial";
		if (rodo.isZgoda1())
			display = "none";
		out.println("</form></table>"+
		"<script>document.getElementById('cookieConsent').style.display ='" + display + "';</script></body></html>");

		out.close();
	}
}
