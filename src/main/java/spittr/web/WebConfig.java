package spittr.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Configuration
@EnableWebMvc
@ComponentScan("spittr.web")
public class WebConfig extends WebMvcConfigurerAdapter {


    @Bean
    public ViewResolver viewResolver() {
	//InternalResourceViewResolver Resolves views as resources internal to the web application (typically JSPs).
	InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	resolver.setPrefix("/views/");
	resolver.setSuffix(".jsp");
	return resolver;
    }


    /**
     * Resolves views by considering the content type desired by
		the client and delegating to another view resolver that can produce that type.   */
    /** REST */
    @Bean
    public ViewResolver cnViewResolver(ContentNegotiationManager cnm) {
	ContentNegotiatingViewResolver cnvr = new ContentNegotiatingViewResolver();
	cnvr.setContentNegotiationManager(cnm);
	return cnvr;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	configurer.enable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	// TODO Auto-generated method stub
	super.addResourceHandlers(registry);
    }

    /** 
     * metodo per forzare la tipologia di risposta 
     * INFLUENCING HOW MEDIA TYPES ARE CHOSEN
     */
    /** REST */
    //	  @Override
    //	  public void configureContentNegotiation(ContentNegotiationConfigurer configurer){
    //	      configurer.defaultContentType(MediaType.APPLICATION_JSON);
    //	  }

    /** REST */
    @Bean
    public ViewResolver beanNameViewResolver() {
	return new BeanNameViewResolver();
    }

    /** REST 
    @Bean
    public View spittles() {
	return new MappingJackson2JsonView();
    }*/
}
