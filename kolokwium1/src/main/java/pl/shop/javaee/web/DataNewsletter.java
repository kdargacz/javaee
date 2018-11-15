package pl.shop.javaee.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pl.shop.javaee.domain.Newsletter;
import pl.shop.javaee.service.NewsStorage;

@WebServlet("/dataNewsletter")
public class DataNewsletter extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
	
		String fullName = request.getParameter("fullName");
		Date odCzasu = Date.valueOf(request.getParameter("odCzasu"));
		Date doCzasu = Date.valueOf(request.getParameter("doCzasu"));
		String czestotliwosc = request.getParameter("czestotliwosc");
		
		String[] tematy = request.getParameterValues("temat");
		String temat ="";
		
		if(tematy != null)
		for (String x : tematy) {
			temat += x + " ";
		}
		
		HttpSession httpSession = request.getSession();
		Newsletter newsletter = (Newsletter) httpSession.getAttribute("newsletter");
		newsletter.setOdCzasu(odCzasu);
		newsletter.setDoCzasu(doCzasu);
		newsletter.setCzestotliwosc(czestotliwosc);
		newsletter.setTematy(temat);
		httpSession.setAttribute("newsletter", newsletter);
		
		
		Newsletter news = new Newsletter(odCzasu, doCzasu, czestotliwosc, temat);
		ServletContext servletContext = getServletContext();
		NewsStorage newStorage = (NewsStorage) servletContext.getAttribute("newsletter");
		newStorage.add(fullName, news);
		servletContext.setAttribute("newsletter", newStorage);
		
		
		out.close();
	}
}
