package spittr.ntt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import spittr.Spitter;

/**
 * serve a memorizzare gli spitter, al posto di una persistenza ufficiale
 * @author mparenti
 *
 */
@Component
public class SpitterNTT {

	private List<Spitter> spitterList;

	public SpitterNTT() {
		this.spitterList = new ArrayList<Spitter>();
	}


	public void add(Spitter spitter){
		if (spitter!=null){
			spitterList.add(spitter);
		}
	}


	/**
	 * @return the spitterList
	 */
	public List<Spitter> getSpitterList() {
		return spitterList;
	}


	/**
	 * @param spitterList the spitterList to set
	 */
	public void setSpitterList(List<Spitter> spitterList) {
		this.spitterList = spitterList;
	}



}
