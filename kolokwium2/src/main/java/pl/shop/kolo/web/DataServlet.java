package pl.shop.kolo.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.shop.kolo.domain.Card;
import pl.shop.kolo.service.StorageService;

@WebServlet("/data")
public class DataServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		response.setContentType("text/html;charset=UTF-8");
		
		String sku = request.getParameter("sku");
	String produkcjaS = request.getParameter("produkcja");
	String cenaS = request.getParameter("cena");
	String qtyS = request.getParameter("qty");
	String producent = request.getParameter("producent");
	String[] kolory = request.getParameterValues("kolory");
	
	DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	Date produkcja = null;
	
	try {
		produkcja = format.parse(produkcjaS);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	double cena = Double.parseDouble(cenaS);
	
	
	int qty = Integer.parseInt(qtyS);
	
	ServletContext servletContext = getServletContext();
	StorageService storage = (StorageService) servletContext.getAttribute("storageC");
	
	Card card = new Card(produkcja, cena, producent, qty, kolory);
	
	
			storage.add(sku, card);
	servletContext.setAttribute("storage", storage);

	PrintWriter out = response.getWriter();

	out.println("<html><head><body>Dodano."
			+ "</body></hmtl>");
out.close();
	
	}
}
