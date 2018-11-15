package pl.shop.javaee.context;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import pl.shop.javaee.service.NewsStorage;
import pl.shop.javaee.service.StorageService;

@WebListener
public class StorageServletContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {

		ServletContext servletContext = servletContextEvent.getServletContext();
		servletContext.setAttribute("storage", new StorageService());
		servletContext.setAttribute("newsletter", new NewsStorage());
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
	}
}