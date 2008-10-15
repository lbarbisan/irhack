package Game.Elements;

import Game.Cellule;
import Game.Interactions.*;
import Game.Donjon;


public class Benite extends Fontaine {
		
  public Benite(Cellule cellule) {
	super(cellule);
	this.nom = "Fontaine bénite";
	this.description = "Cette fontaine vous permet de récupérer un peu de force";

	actions = new ActionsManager(this);
  }
  
  public void  Boire(Fontaine Source, Creature Destination)
  {
	int tmp;
		
	if(Donjon.Distance(Source, Destination)>1){
		Destination.getDonjon().print("La cible est trop loin");
			return;
	}
	if(Used==0)
	{		
		tmp =(int) Destination.Blessure.Get_Value();
		/*	while(Destination.Blessure.Del_Last()!=false){}*/
		Destination.Blessure.ResetMod(tmp - (int)(Math.random() *10 + 1));
		Destination.getDonjon().print("Vous avez gagné des points de vie : " +  Destination.PV.Get_Value());
		Used++;
	}
  }
  

}