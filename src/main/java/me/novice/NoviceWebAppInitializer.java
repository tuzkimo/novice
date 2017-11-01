package me.novice;

import ch.qos.logback.ext.spring.web.LogbackConfigListener;
import me.novice.config.RootConfig;
import me.novice.config.WebConfig;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.util.IntrospectorCleanupListener;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class NoviceWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    servletContext.addListener(IntrospectorCleanupListener.class);
    servletContext.addListener(LogbackConfigListener.class);
    super.onStartup(servletContext);
  }

  @Override
  protected Filter[] getServletFilters() {
    CharacterEncodingFilter filter = new CharacterEncodingFilter();
    filter.setEncoding("utf-8");
    filter.setForceEncoding(true);
    return new Filter[]{filter};
  }

  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class[]{RootConfig.class};
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class[]{WebConfig.class};
  }

  @Override
  protected String[] getServletMappings() {
    return new String[]{"/"};
  }
}
