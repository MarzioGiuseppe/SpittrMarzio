package spittr.web;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spittr.Spitter;
import spittr.data.SpitterRepository;


@Controller
@RequestMapping("/spitter")
public class SpitterController {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private SpitterRepository spitterRepository;


	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String showRegistrationForm(Model model){
		logger.info("showRegistrationForm - start/end" );
		model.addAttribute(new Spitter()); // se non lo faccio, la jsp non riceve spitter as request attribute
		return "registerForm";
	}

	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String processRegistration(@Valid Spitter spitter, Errors errors, Model model) {
		logger.info("processRegistration - start - name=" + spitter.getFirstName() + " lastname=" + spitter.getLastName() + " email=" + spitter.getEmail());
		logger.info("ErrorCount=" + errors.getErrorCount());
		System.out.println("ErrorCount=" + errors.getErrorCount());
		if (errors.hasErrors()){
			List<FieldError> elencoErrori = errors.getFieldErrors();
			model.addAttribute("elencoErrori",elencoErrori);
			return "registerForm"; //se ci sono errori ritorna sulla stessa pagina
		}
		spitterRepository.save(spitter);
		return "redirect:/spitter/" + spitter.getUsername() + "?provaParam=1975";
	}

	@RequestMapping(value="/{username}", method=RequestMethod.GET)
	public String showSpitterProfile(Model model, @PathVariable String username,
			@RequestParam(value="provaParam",defaultValue="100") long max ){
		logger.info("showSpitterProfile - begin - username ricevuto=" + username);
		logger.info("max = " + max);
		Spitter spitter = spitterRepository.findByUsername(username);
		model.addAttribute("spitter", spitter);
		return "profile";
	}


}
