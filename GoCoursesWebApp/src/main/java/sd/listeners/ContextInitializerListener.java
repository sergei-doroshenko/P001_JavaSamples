package sd.listeners;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sd.controllers.ProductAllController;
import sd.dao.ProductDao;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Sergei on 27.04.2015.
 */
public class ContextInitializerListener implements ServletContextListener {
    private Logger log = Logger.getLogger("ContextInitializer");

    public void contextInitialized(ServletContextEvent servletContextEvent) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/application-context.xml");
        ProductDao dao = (ProductDao) applicationContext.getBean("productDao");
        servletContextEvent.getServletContext().setAttribute("productDao", dao);
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
