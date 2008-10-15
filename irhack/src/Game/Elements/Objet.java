package Game.Elements;


/**
 * <p>Titre : JDR</p>
 * <p>Description : Gestion d'un JDR</p>
 * <p>Copyright : Copyright (c) 2004</p>
 * <p>Société : Ingénieur 200</p>
 * @author Barbisan Laurent
 * @version 1.0
 */
import Game.Interactions.ActionsManager;
import Game.Cellule;
import Game.Modificateurs.*;

public  abstract class Objet extends Fixe{

  private Modificateur Bonus;
  
  public Objet(Cellule cellule) {
  		super(cellule);
    	actions = new ActionsManager(this);
  }

  public abstract  void On_Contenaire_Add(Object Dest);
  public abstract void On_Contenaire_Remove(Object Dest);
  
  public void Prendre(Objet Source, Creature Destination)
  {
  		Destination.Sac.Add_Object(this);
  }

}