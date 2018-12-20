package pl.shop.javaee.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pl.shop.javaee.domain.Tree;
import pl.shop.javaee.service.StorageService;

@WebServlet("/close")
public class CloseServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		
		ServletContext servletContext = getServletContext();
		StorageService storage = (StorageService) servletContext.getAttribute("storage");
		Map<String, Tree> db = storage.getAllTrees();

		HttpSession session = request.getSession();
		StorageService storageS = (StorageService) session.getAttribute("storage");
		Map<String, Tree> cart = storageS.getAllTrees();

		// aktualizuje dane w kontekście aplikacji, po dokonaniu zakupu
		for (String x : cart.keySet()) {

			int qtyS = cart.get(x).getQty();
			int qtyA = db.get(x).getQty();
			if (qtyS == qtyA) {
				storage.rm(x);
			} else {
				int qtyN = qtyA - qtyS;
				Tree tree = cart.get(x);
				tree.setQty(qtyN);
				storage.add(x, tree);
			}
		}
		servletContext.setAttribute("storage", storage);

		session.invalidate();
		response.sendRedirect(request.getContextPath() + "/shop");

	}
}
