package web;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MyWebApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.scan("demo");

        servletContext.addListener(new ContextLoaderListener(context));

        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);

        ServletRegistration.Dynamic appServlet = servletContext.addServlet("appServlet", dispatcherServlet);
        appServlet.addMapping("/");
    }
}
