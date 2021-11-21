package org.example;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {
        XmlWebApplicationContext appContext = new XmlWebApplicationContext();
        appContext.setConfigLocation("/WEB-INF/appconfig-root.xml");

        servletContext.addListener(new ContextLoaderListener(appContext));

        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
//        webContext.scan("org.example");
        webContext.setConfigLocation("/WEB-INF/appconfig-mvc.xml");

        DispatcherServlet dispatcherServlet = new DispatcherServlet(webContext);

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", dispatcherServlet);
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
