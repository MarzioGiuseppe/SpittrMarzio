package spittr.ntt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import spittr.Spittle;

/**
 * 
 * serve a memorizzare gli spittle, al posto di una persistenza ufficiale
 * 
 * @author mparenti
 *
 */
@Component
public class SpittleNTT {

    private List<Spittle> spittleList;

    
    public SpittleNTT(){
	spittleList = new ArrayList<Spittle>();
    }
    
    public void add(Spittle spittle){
	if (spittle!=null){
	    spittleList.add(spittle);
	}
    }
    
    
    public void addAll(List<Spittle> elenco){
	for (Spittle sp:elenco){
	    spittleList.add(sp);
	}
    }
    
    

    public List<Spittle> getSpittleList() {
	return spittleList;
    }

    public void setSpittleList(List<Spittle> spittleList) {
	this.spittleList = spittleList;
    }
    
    
    
}
