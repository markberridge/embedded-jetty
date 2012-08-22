package uk.co.markberridge.spring;

import javax.servlet.ServletContext;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;

/**
 * An extension of {@link ContextLoaderListener} which is aware of the parent {@link ApplicationContext} in which it was
 * created. The {@link WebApplicationContext} created will have the {@link ApplicationContext} as its parent.
 * 
 * @author mberridge
 */
public class ContextAwareContextLoaderListener extends ContextLoaderListener implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    protected ApplicationContext loadParentContext(ServletContext servletContext) {
        return this.applicationContext;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
