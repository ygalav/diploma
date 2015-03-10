package com.ygalav.spring.config;
  
import org.springframework.context.annotation.Bean;  
import org.springframework.context.annotation.ComponentScan;  
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;  
  
@Configuration //Marks this class as configuration
//Specifies which package to scan
@ComponentScan({"com.ygalav.spring.facade", "com.ygalav.spring.controller","com.ygalav.spring.service", "com.ygalav.spring.service", "com.ygalav.spring.repository"})
//Enables Spring's annotations 
@EnableWebMvc
@EnableTransactionManagement
@Import({PersistenceConfig.class})
public class Config extends WebMvcConfigurerAdapter {
      
    @Bean  
    public UrlBasedViewResolver setupViewResolver() {  
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();  
        resolver.setPrefix("/WEB-INF/pages/");
        resolver.setSuffix(".jsp");  
        resolver.setViewClass(JstlView.class);  
        return resolver;  
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/css/**").addResourceLocations("/resources/css/").setCachePeriod(31556926);
        registry.addResourceHandler("/resources/fonts/**").addResourceLocations("/resources/fonts/").setCachePeriod(31556926);
        registry.addResourceHandler("/resources/img/**").addResourceLocations("/resources/img/").setCachePeriod(31556926);
        registry.addResourceHandler("/resources/js/**").addResourceLocations("/resources/js/").setCachePeriod(31556926);
    }
  
}  
