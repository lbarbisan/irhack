package Game;

import java.util.Hashtable;
import Utils.Position;

public class HistorySalle {
	private final static String SEPARATEUR = "*"; 
	
	Hashtable histoSalles;
	
	public HistorySalle() {
		histoSalles = new Hashtable();
	}
	
  	public void addSalle(Salle salle) {
  		Position pos = salle.getPosition();
		histoSalles.put(this.getKey(pos), salle);
  	}
  
  	public Salle getSalle(Position pos) {
   		return (Salle) histoSalles.get(this.getKey(pos));
  	}
  	
  	private String getKey(Position pos) {
  		return (String) (pos.getAbs() + SEPARATEUR + pos.getOrd());
  	}
}