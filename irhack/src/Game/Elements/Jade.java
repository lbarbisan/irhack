package Game.Elements;

import Game.Cellule;
import Game.Interactions.*;
import Game.Donjon;

public class Jade extends Fontaine {
	
  public Jade(Cellule cellule) {
	super(cellule);
	this.nom = "Fontaine de jade";
	this.description = "Cette fontaine vous afflige des dégats";
	
	actions = new ActionsManager(this);
  }
  
  public void Boire(Fontaine source, Creature destination )
  {
  		int tmp;
  		
	if(Donjon.Distance(source, destination)>1){
		System.err.println("La cible est trop loin");
			return;
	}
  	if(Used==0)
  	{
		tmp =(int) destination.Blessure.Get_Value();
		destination.Blessure.ResetMod(tmp + (int)(Math.random() *10 + 1));
		System.out.println("Vous avez perdue des points des vie : " +  destination.PV.Get_Value());
		Used++;
  }
  }

}