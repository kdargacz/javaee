package pl.shop.kolo.web;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/data")
public class DataServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String produkcjaS = request.getParameter("produkcja");
	String cenaS = request.getParameter("cena");
	String qty = request.getParameter("qty");
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
	int cena = Integer.parseInt(cenaS);
	
	
	
	
	
	}
}
