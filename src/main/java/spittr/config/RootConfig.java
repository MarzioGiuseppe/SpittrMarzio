package spittr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import spittr.data.SpitterRepository;
import spittr.data.SpitterRepositoryImpl;
import spittr.data.SpittleRepository;
import spittr.data.SpittleRepositoryImpl;

@Configuration
@ComponentScan(basePackages={"spittr"})
@EnableWebMvc
//	excludeFilters={
//	@Filter(type=FilterType.ANNOTATION, value=EnableWebMvc.class)
//	})
public class RootConfig {

    @Bean
    public SpittleRepository spittleRepository(){
	return new SpittleRepositoryImpl();
    }


    @Bean
    public SpitterRepository spitterRepository(){
	return new SpitterRepositoryImpl();
    }


}
