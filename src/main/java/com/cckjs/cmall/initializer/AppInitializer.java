package com.cckjs.cmall.initializer;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * 系统初始化启动程序
 *
 * @author 
 */
public class AppInitializer implements WebApplicationInitializer {

    private static final String CONFIG_LOCATION = "com.cckjs.cmall.config";
    private static final String MAPPING_URL = "/";

    @Override
    public void onStartup(ServletContext servletContext)
            throws ServletException {
        WebApplicationContext context = getContext();

        // 监听地址
        servletContext.addListener(new ContextLoaderListener(context));
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet(
                "DispatcherServlet", new DispatcherServlet(context));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping(MAPPING_URL);

        // characterEncoding
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        FilterRegistration.Dynamic encodingFilter = servletContext.addFilter(
                "characterEncodingFilter", characterEncodingFilter);
        encodingFilter.addMappingForUrlPatterns(null, false, MAPPING_URL);

    }

    /**
     * 加载注解程序路径
     *
     * @return
     */
    private AnnotationConfigWebApplicationContext getContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation(CONFIG_LOCATION);
        return context;
    }

}
