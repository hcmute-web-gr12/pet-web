package com.group12.petweb;

import com.group12.petweb.controller.AdminDashboardController;
import com.group12.petweb.controller.AdminPetController;
import com.group12.petweb.controller.HomeController;
import com.group12.petweb.controller.LoginController;
import com.group12.petweb.controller.ProductsController;
import com.group12.petweb.controller.SignUpController;
import com.group12.petweb.controller.UserProfileController;
import com.group12.petweb.controller.api.AdminPetApiController;
import com.group12.petweb.controller.api.UserProfileApiController;
import com.group12.petweb.dao.PetDao;
import com.group12.petweb.dao.PetDaoImpl;
import com.group12.petweb.dao.UserCredentialsDao;
import com.group12.petweb.dao.UserCredentialsDaoImpl;
import com.group12.petweb.filter.AuthorizationFilter;
import com.group12.petweb.service.ContextRedirector;
import com.group12.petweb.service.Redirector;
import com.group12.petweb.util.MathUtils;
import com.group12.petweb.util.MathUtilsImpl;
import com.cloudinary.*;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.cfg.Environment;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Properties;

@WebListener
public class Application implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {
	private final String TEMP_DIR = "/tmp";
	private final EntityManagerFactory factory;
	private final UserCredentialsDao userCredentialsDao;
	private final PetDao petDao;
	private final Redirector redirector;
	private final MathUtils mathUtils;

	public Application() {
		final Properties properties = new Properties();
		properties.put(Environment.USER, System.getenv("CONNECTION_USER"));
		properties.put(Environment.PASS, System.getenv("CONNECTION_PASSWORD"));
		properties.put(Environment.URL, System.getenv("CONNECTION_URL"));
		factory = Persistence.createEntityManagerFactory("default", properties);
		userCredentialsDao = new UserCredentialsDaoImpl(factory);
		petDao = new PetDaoImpl(factory);
		redirector = new ContextRedirector();
		mathUtils = new MathUtilsImpl();
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		final var mb = 1024 * 1024;
		final var context = sce.getServletContext();
		final var cloudinary = new Cloudinary(new HashMap<String, String>() {
			{
				put("cloud_name", System.getenv("CLOUDINARY_CLOUD_NAME"));
				put("api_key", System.getenv("CLOUDINARY_API_KEY"));
				put("api_secret", System.getenv("CLOUDINARY_API_SECRET"));
			}
		});

		context.addServlet("homeServlet", new HomeController()).addMapping("/home");
		context.addServlet("loginServlet", new LoginController(userCredentialsDao, redirector)).addMapping("/login");
		context.addServlet("signUpServlet", new SignUpController(userCredentialsDao, redirector)).addMapping("/signup");
		context.addServlet("productsServlet", new ProductsController()).addMapping("/products");

		context.addServlet("userProfileServlet", new UserProfileController(userCredentialsDao, redirector))
				.addMapping("/user", "/user/profile");
		context.addServlet("userProfileApiServlet", new UserProfileApiController(userCredentialsDao))
				.addMapping("/api/user/profile");

		context.addServlet("adminDashboardServlet", new AdminDashboardController()).addMapping("/admin",
				"/admin/dashboard");

		context.addServlet("adminPetServlet", new AdminPetController(petDao, cloudinary, mathUtils)).addMapping("/admin/pet");
		final var adminPetApiServlet = context.addServlet("adminPetApiServlet", new AdminPetApiController(petDao, cloudinary, mathUtils));
		adminPetApiServlet.addMapping("/api/admin/pet");
		adminPetApiServlet.setMultipartConfig(new MultipartConfigElement(TEMP_DIR, 10 * mb, 100 * mb, mb));

		context.addFilter("authorizationFilter", new AuthorizationFilter(redirector)).addMappingForServletNames(
				EnumSet.of(DispatcherType.REQUEST),
				false,
				"userProfileServlet",
				"userProfileApiServlet",
				"adminDashboardServlet",
				"adminPetServlet",
				"adminPetApiServlet");
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
