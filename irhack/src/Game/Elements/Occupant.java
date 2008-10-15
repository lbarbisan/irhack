package Game.Elements;

import Game.Cellule;
import Game.Interactions.*;
/*import Game.Contenaires.ContenairesManager;
import Game.Modificateurs.AttributsManager;*/

public abstract class Occupant {
  	
  	protected Cellule cellule;
	protected  ActionsManager actions ;
/*	protected  AttributsManager attributs;
	protected ContenairesManager contenaires;*/
  	
  	public String nom;						// nom du joueur
  	public String description;			// description du joueur
  	public int ActionRestante = 0;	// Action restante pour ce tour

  	public Occupant (Cellule cellule) {
		this.cellule = cellule;
		this.cellule.prendreOccupant(this);
		actions = new ActionsManager(this);
  	}

	/* Propriété Cellule */
  	public Cellule getCellule() {
	 	return this.cellule;
  	}

  	public void setCellule(Cellule cel) {
		this.cellule = cel;
  	}
  	
  	/* Propriété Actions */
	public String[] getInteractions(Object Destination)
		{
			return actions.getInteractions(Destination);
		}
		
	public String[] getUserInteractions(Object Destination)
			{
				return actions.getUserInteractions(Destination);
			}
  	
	/* Execution d'une action */
	public void doAction(String action, Object Destination){
		 this.actions.Try(action,this, Destination);
		 
	}

}

