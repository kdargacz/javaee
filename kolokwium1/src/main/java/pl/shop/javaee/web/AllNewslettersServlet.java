package pl.shop.javaee.web;

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

import pl.shop.javaee.domain.Newsletter;
import pl.shop.javaee.service.NewsStorage;


@WebServlet("/allnewsletters")
public class AllNewslettersServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();	
		
		
		ServletContext servletContext = getServletContext();
		NewsStorage newStorage = (NewsStorage) servletContext.getAttribute("newsletter");
		
		Map<String, Newsletter> db = newStorage.getAllNewsletters();
		
		Set<Map.Entry<String, Newsletter>> xSet = db.entrySet();
		for (Map.Entry<String, Newsletter> x : xSet) {
			out.println(x.getKey() + " " + x.getValue() + "<br/>");
		}
		
		out.close();
	}
}
