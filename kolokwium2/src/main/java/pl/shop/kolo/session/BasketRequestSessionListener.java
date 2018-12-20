package pl.shop.kolo.session;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import pl.shop.javaee.domain.Rodo;
import pl.shop.javaee.service.StorageService;

@WebListener
public class BasketRequestSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent httpSessionEvent) {

		HttpSession session = httpSessionEvent.getSession();
		session.setAttribute("storageS", new StorageService());
		//session.setAttribute("rodo", new Rodo());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
	}
}
