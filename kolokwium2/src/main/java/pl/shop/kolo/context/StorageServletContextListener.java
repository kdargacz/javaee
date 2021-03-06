package pl.shop.kolo.context;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import pl.shop.kolo.service.StorageService;


@WebListener
public class StorageServletContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {

		ServletContext servletContext = servletContextEvent.getServletContext();
		servletContext.setAttribute("storageC", new StorageService());
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
	}
}