package com.ssdev.smartinv.configuration;

import com.ssdev.smartinv.util.hibernate.HBConfig;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@ComponentScan({"com.ssdev.smartinv"})
@EnableWebMvc
public class Config implements WebMvcConfigurer {
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/", ".jsp");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/resources/style/");
        registry.addResourceHandler("/javascript/**").addResourceLocations("/resources/javascript/");
        registry.addResourceHandler("/image/**").addResourceLocations("/resources/image/");
    }

    @Bean
    public SessionFactory sessionFactory() {
        return HBConfig.sessionFactory();
    }

    @Primary
    public EntityManagerFactory getEntityManagerFactory(@Autowired SessionFactory sessionFactory) {
        return sessionFactory.unwrap(EntityManagerFactory.class);
    }
}
