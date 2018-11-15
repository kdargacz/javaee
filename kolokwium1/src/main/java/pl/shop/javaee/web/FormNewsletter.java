package pl.shop.javaee.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/newsletter")
public class FormNewsletter extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>"+
		"<form action='dataNewsletter' method='post'>"+
				"Data newslettera od: <input type='text' name='odCzasu'><br/>"+
		"Data newslettera do: <input type='text' name='doCzasu'><br/>"+
				"Czestotliwosc: <br/> <input type='radio' name='czestotliwosc' value='codziennie'>Codziennie<br/>"+
				"<input type='radio' name='czestotliwosc' value='tygodniowo'>Tygodniowo<br/>"+
				"<input type='radio' name='czestotliwosc' value='miesiecznie'>Miesiecznie<br/>"+
				"Na tematy zwiazane z:<br/>"+
				"<input type='checkbox' name='temat' value='nowe_produkty'>Nowe produkty</br>"+
				"<input type='checkbox' name='temat' value='nowe_promocje'>Nowe promocje</br>"+
			"<input type='submit' value='ok'></form></body></html>");
		
		
		
		out.close();
	}
	
}
