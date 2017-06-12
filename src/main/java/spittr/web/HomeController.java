package spittr.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/ciao") //se abilitato diventa il prefisso per tutti gli altri requestMapping
public class HomeController {

	@RequestMapping(value="/", method=GET)
	public String home(){
		return "home";
	}
	
	@RequestMapping(value="/pippo" , method=GET)
	public String homePippo(){
		return "pippo";
	}
	
	@RequestMapping(value="/prova" , method=GET)
	public String homePippo1(){
		return "pippo";
	}
	
}
