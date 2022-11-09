import com.group12.petweb.controller.HomeController;
import com.group12.petweb.controller.LoginController;
import com.group12.petweb.controller.ProductsController;
import com.group12.petweb.controller.SignUpController;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Application implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent event) {
        ServletContext context = event.getServletContext();
        context.addServlet("homeServlet", new HomeController()).addMapping("/home");
        context.addServlet("loginServlet", new LoginController()).addMapping("/login");
        context.addServlet("signUpServlet", new SignUpController()).addMapping("/signup");
        context.addServlet("productsServlet", new ProductsController()).addMapping("/products");
    }
}
