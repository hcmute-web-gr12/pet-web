package com.group12.petweb;

import com.group12.petweb.controller.HomeController;
import com.group12.petweb.controller.LoginController;
import com.group12.petweb.controller.ProductsController;
import com.group12.petweb.controller.SignUpController;
import com.group12.petweb.dao.UserDao;
import com.group12.petweb.dao.UserDaoImpl;
import com.group12.petweb.filter.AuthorizationFilter;
import com.group12.petweb.service.ContextRedirector;
import com.group12.petweb.service.Redirector;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.cfg.Environment;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import java.util.EnumSet;
import java.util.Properties;

@WebListener
public class Application implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {
	private final EntityManagerFactory factory;
	private final UserDao userDao;
	private final Redirector redirector;

	public Application() {
		final Properties properties = new Properties();
		properties.put(Environment.USER, System.getenv("CONNECTION_USER"));
		properties.put(Environment.PASS, System.getenv("CONNECTION_PASSWORD"));
		properties.put(Environment.URL, System.getenv("CONNECTION_URL"));
		factory = Persistence.createEntityManagerFactory("default", properties);
		userDao = new UserDaoImpl(factory);
		redirector = new ContextRedirector();
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		context.addServlet("homeServlet", new HomeController()).addMapping("/home");
		context.addServlet("loginServlet", new LoginController(userDao, redirector)).addMapping("/login");
		context.addServlet("signUpServlet", new SignUpController(userDao, redirector)).addMapping("/signup");
		context.addServlet("productsServlet", new ProductsController()).addMapping("/products");

		context.addFilter("authorizationFilter", new AuthorizationFilter(redirector))
				.addMappingForServletNames(EnumSet.allOf(DispatcherType.class), false, "<todo>");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		factory.close();
	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent sbe) {
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent sbe) {
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent sbe) {
	}
}