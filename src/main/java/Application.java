import com.group12.petweb.controller.HomeController;
import com.group12.petweb.controller.LoginController;
import com.group12.petweb.controller.ProductsController;
import com.group12.petweb.controller.SignUpController;
import com.group12.petweb.service.HibernateSessionFactory;
import com.group12.petweb.service.HibernateSessionFactoryImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class Application implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {
    private final HibernateSessionFactory hibernateSessionFactory;
    public Application() {
        hibernateSessionFactory = new HibernateSessionFactoryImpl();
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        context.addServlet("homeServlet", new HomeController()).addMapping("/home");
        context.addServlet("loginServlet", new LoginController(hibernateSessionFactory)).addMapping("/login");
        context.addServlet("signUpServlet", new SignUpController()).addMapping("/signup");
        context.addServlet("productsServlet", new ProductsController()).addMapping("/products");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
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
