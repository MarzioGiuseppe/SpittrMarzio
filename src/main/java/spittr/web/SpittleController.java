package spittr.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import spittr.Spittle;
import spittr.data.SpittleRepository;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
	
	@Autowired
	private SpittleRepository spittleRepository;
	
	private static final String MAX_LONG_AS_STRING = "9223372036854775807";
	
	public SpittleController(SpittleRepository spittleRepository) {
		this.spittleRepository = spittleRepository;
	}

//	@RequestMapping
//	public String spittles(Model model){
//		List<Spittle> spittleList = spittleRepository.findSpittles(Long.MAX_VALUE, 20);
//		model.addAttribute("spittleList",spittleList);
//		return "spittles";
//	}
	
//	@RequestMapping(method=RequestMethod.GET)
//	public String spittles(Model model,
//		@RequestParam(value="max",defaultValue=MAX_LONG_AS_STRING) long max, 
//		@RequestParam(value="count", defaultValue="20") int count){
//	    
//	    List<Spittle> spittleList = spittleRepository.findSpittles(max,count);
//	    model.addAttribute("spittleList",spittleList);
//	    return "spittles";
//	}
	
	@RequestMapping(method=RequestMethod.GET, produces="application/json")
	public @ResponseBody List<Spittle> spittles(
		@RequestParam(value="max",
		defaultValue=MAX_LONG_AS_STRING) long max,
		@RequestParam(value="count", defaultValue="20") int count) {
	    
	    List<Spittle> spittleList = spittleRepository.findSpittles(max,count);
	    	    
	    return spittleList;				
	}
	
	@RequestMapping(value="/{numeroSpittle}", method=RequestMethod.GET)
	public String spittle(
			@PathVariable("numeroSpittle") long spittleId,
			Model model){
		
		Spittle spittle = spittleRepository.findOne(spittleId);
		model.addAttribute("spittle",spittle);
		
		return "spittle";
	}
	
	
	public SpittleRepository getSpittleRepository() {
		return spittleRepository;
	}

	public void setSpittleRepository(SpittleRepository spittleRepository) {
		this.spittleRepository = spittleRepository;
	}
	
	
}
