package Game;

import Game.Elements.*;
import Utils.Point;

public class Cellule {
   	private Cellule sud;
   	private Cellule est;
  	private Cellule nord;
   	private Cellule ouest;
   	public Point p;

	private Occupant fixe;
	private Occupant creature;
	private Occupant meuble;
  	
  	public Cellule (Cellule sud,Cellule est, Cellule nord, Cellule ouest, Occupant occupant, Point p){
		this.sud = sud;
		this.est = est;
		this.nord = nord;
		this.ouest = ouest;
		this.prendreOccupant(occupant);
		this.p = p;
  	}
  
  	public Cellule (){
		this(null,null,null,null,null, null);
  	}
  	
  	public Cellule(Point p)
  	{
  		this(null, null, null, null, null,p);
  	}

  	public boolean estLibre(Occupant occupant) {
		if(occupant instanceof Creature)
			return estLibreCreature();
		if(occupant instanceof Meuble)
			return estLibreMeuble();
		if(occupant instanceof Fixe)
			return estLibreFixe();
		return false;
  	}

	public boolean estLibreCreature() {
		return (fixe == null && creature == null);
	}

	public boolean estLibreFixe() {
		return (fixe == null && creature == null && meuble == null);
	}

	public boolean estLibreMeuble() {
		return (fixe == null && meuble == null);
	}

  	public void prendreOccupant(Occupant occupant){
		if(estLibre(occupant)) {
			if(occupant instanceof Creature)
				this.creature = occupant;
			else if(occupant instanceof Meuble)
				this.meuble = occupant;
			else if(occupant instanceof Fixe)
				this.fixe = occupant;
			occupant.setCellule(this);
		}
   	}

  	public void perdreOccupant(Occupant occupant){
		if(occupant instanceof Fixe) {
			if(this.fixe != null)
				this.fixe.setCellule(null);
			this.fixe = null;					
		}
		else if(occupant instanceof Meuble) {
			if(this.meuble != null)
				this.meuble.setCellule(null);
			this.meuble = null;					
		}
		else if(occupant instanceof Creature) {
			if(this.creature != null)
				this.creature.setCellule(null);
			this.creature = null;					
		}
  	}

  	//accesseurs
  	public Cellule getEst() { return this.est;}
  	public Cellule getSud() { return this.sud;}
  	public Cellule getOuest() { return this.ouest;}
  	public Cellule getNord() { return this.nord;}

  	public void setEst(Cellule c) { this.est = c;}
  	public void setSud(Cellule c) { this.sud = c;}
  	public void setOuest(Cellule c) { this.ouest = c;}
  	public void setNord(Cellule c) { this.nord = c;}
  
  
  	public String toString() {
		return " ";
  	}
  
	public Meuble getMeuble() {
		return (Meuble)meuble;
	}

	public Fixe getFixe() {
		return (Fixe)fixe;
	}	

	public Creature getCreature() {
		return (Creature)creature;
	}	

	public Occupant getOccupant() {
		if(this.getFixe()!=null)
			return this.getFixe();
		else if(this.getCreature()!=null)
			return this.getCreature();
		else if(this.getMeuble() != null)
			return this.getMeuble();
		return null;
	}	
}