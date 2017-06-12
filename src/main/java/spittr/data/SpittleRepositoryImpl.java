package spittr.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import spittr.Spittle;
import spittr.ntt.SpittleNTT;

//@Component //MARZ : non serve perchè ho creato il bean nel configuration
public class SpittleRepositoryImpl implements SpittleRepository {

    @Autowired
    private SpittleNTT spittleNTT;
    
    
	@Override
	public List<Spittle> findSpittles(long max, int count) {
	    
	    if (spittleNTT.getSpittleList().isEmpty()){
		this.loadMockData(count);
	    }
		return spittleNTT.getSpittleList();
	}

	@Override
	public void loadMockData(int count) {
	    List<Spittle> lista = createSpittleList(count);
	    spittleNTT.addAll(lista);
	}
	
	
	private List<Spittle> createSpittleList(int count) {
		List<Spittle> spittles = new ArrayList<Spittle>();
		for (int i=0; i < count; i++) {
			spittles.add(new Spittle(i,"Spittle " + i, new Date()));
		}
		return spittles;
	}
	
	
	public int size(){
		return spittleNTT.getSpittleList().size();
	}

	@Override
	public Spittle findOne(long id) {
		System.out.println("findOne() - begin - param = " + id);
		List<Spittle> lista = createSpittleList(20);
		
		int posizione = id>20?20:(int)id;
		
		Spittle spittle = lista.get(posizione);
		System.out.println("spittle letto = " + spittle.getMessage() + " " + spittle.getTime());
		return spittle;
	}


	@Override
	public void save(Spittle spittle) {
	    // TODO Auto-generated method stub
	    
	}


	@Override
	public boolean isEmpty() {
	    if (this.size()<1){
		return true;
	    }
	    return false;
	}

	
}
