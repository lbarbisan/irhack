package Game.Elements;

import Game.Cellule;
import Game.Donjon;
import Game.Interactions.*;


abstract public class Mobile extends Occupant {
 
	protected Donjon donjon;
 
 	public Mobile (Cellule cellule, Donjon donjon){
		super(cellule);
		this.donjon = donjon;
		actions = new ActionsManager(this);
  	}

	public Donjon getDonjon(){
		return donjon;
	}
	
	
	
	public void p_gotoSud(Mobile source, Object Destination) {
		boolean ok = false;
		if(source.getCellule().getSud() != null){
			ok =source.getCellule().getSud().estLibre(source);
			if (ok)
				this.deplacerVers(source,  source.getCellule().getSud());
		}	
		else
			source.getDonjon().changerSalle(1);
			 	
		Donjon.DecrementActions(source);
	}

	public void p_gotoNord(Mobile source, Object Destination) {
	boolean ok = false;
		if(source.getCellule().getNord() != null){
			ok =  source.getCellule().getNord().estLibre(source);
			if (ok)
				this.deplacerVers(source,  source.getCellule().getNord());
		}
		else
		{
			source.getDonjon().changerSalle(2);
			ok=true;
		} 	
		Donjon.DecrementActions(source);
	}

	public void p_gotoOuest(Mobile source, Object Destination) {
		boolean ok = false;
		if(source.getCellule().getOuest() != null){
			ok =  source.getCellule().getOuest().estLibre(source);
			if (ok)
				this.deplacerVers( source,  source.getCellule().getOuest());
		}	
		else
			source.getDonjon().changerSalle(4);
		
		Donjon.DecrementActions(source);
	
	}

	public void p_gotoEst(Mobile source, Object Destination) {
		boolean ok = false;
		if(source.getCellule().getEst() != null){
			ok =  source.getCellule().getEst().estLibre(source);
			if (ok)
				this.deplacerVers( source,  source.getCellule().getEst());
		}
		else
			source.getDonjon().changerSalle(3);	
		Donjon.DecrementActions(source);
	}

	public void Description(Occupant Source, Occupant Destination)
		{
			System.out.println(Source.description);	
		}


	/* Action interne au monstre */
	private void deplacerVers(Mobile mobile, Cellule celluleDest) {
		  mobile.getCellule().perdreOccupant(mobile);
		  celluleDest.prendreOccupant(mobile);
	}

}