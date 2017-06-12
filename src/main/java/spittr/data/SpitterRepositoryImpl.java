package spittr.data;

import org.springframework.beans.factory.annotation.Autowired;

import spittr.Spitter;
import spittr.ntt.SpitterNTT;

public class SpitterRepositoryImpl implements SpitterRepository {

    @Autowired
    private SpitterNTT spitterNTT;
    
    
    @Override
    public void save(Spitter spitter) {
	spitterNTT.add(spitter);
    }

    @Override
    public Spitter findByUsername(String username) {
	for (Spitter elem:spitterNTT.getSpitterList()){
	    if (elem.getUsername().equals(username)){
		return elem;
	    }
	}
	return null;
    }
    
   

}
