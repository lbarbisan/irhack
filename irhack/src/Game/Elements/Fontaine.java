package Game.Elements;

import Game.Cellule;
import Game.Interactions.*;

public abstract class Fontaine extends Meuble {
  protected int Used = 0;
  
  public Fontaine(Cellule cellule) {
	super(cellule);
	actions = new ActionsManager(this);
  }
  
  public abstract void  Boire(Fontaine Source, Creature Destination);
}