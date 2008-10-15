package Game;

import Game.Elements.*;

public class Porte extends Meuble {
	private Salle salleDest;
	private Cellule cellDest;
	
	public Porte(Cellule cellule, Salle salle, Cellule cellDest) {
		super(cellule);
		this.salleDest = salle;
		this.cellDest = cellDest;
	}
	
	public Porte(Cellule cellule) {
		this(cellule,null, null);
	}
	
	public void setSalleDest(Salle salleDest) {
		this.salleDest = salleDest;
	}

	public Salle getSalleDest() {
		return this.salleDest;
	}	

	public void setCellDest(Cellule cellDest) {
		this.cellDest = cellDest;
	}

	public Cellule getCellDest() {
		return this.cellDest;
	}	

	public String toString() {
		return " ";
	}
	
	public void affiche() {
	  	System.out.print(this.toString());
	}
}
