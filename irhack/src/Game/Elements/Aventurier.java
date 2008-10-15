package Game.Elements;

import Game.Cellule;
import Game.Interactions.ActionsManager;
import Game.Donjon;

public class Aventurier extends Creature {
  
 /* Constructeur */
  public Aventurier(int Vitesse, int Endurance, int Attaque, int Defense, int XP, int Niv, Cellule cellule, Donjon donjon) {
	super(Vitesse, Endurance, Attaque, Defense, XP, Niv, cellule, donjon);
	this.nom = "Indianna Jones";
	this.description = "Aventurier venu du fin fond de l\'Amazonie";
	this.actions = new ActionsManager(this);
	
  }
 public Aventurier(Aventurier aventurier)
  {
  	super((Creature)aventurier);
  }
  

  
  
/* A C T I O N S */
/* p_ => Action non visible dans le menu utilisateur */	
/* Déplacement ver le bas */
public void Monter(Mobile source, Object Destination) {
	source.doAction("p_gotoNord", null);
  }
  /* Déplacement ver le bas */
public void Descendre(Mobile source, Object Destination) {
	  source.doAction("p_gotoSud", null);
	}
	/* Déplacement ver le bas */
public void Gauche(Mobile source, Object Destination) {
		source.doAction("p_gotoOuest", null);
	  }
	/* Déplacement ver le bas */
public void Droite(Mobile source, Object Destination) {
		source.doAction("p_gotoEst", null);
	  }
public void Attaquer(Aventurier Source, Monstre Destination) {
		Source.doAction("p_Attaquer", (Creature)Destination);	 
	  }
 public void  p_Jouer(Aventurier aventurier, Donjon donjon)
{
	donjon.SetUserPlay(true);
	while(aventurier.ActionRestante>0)
	{
	
	}
	donjon.SetUserPlay(false);
}

public void doAction(String action, Object Destination){
		this.actions.Try(action,this, Destination);
		this.getDonjon().refreshAttribut(this.Attributs.getAllContenaire());
	}

}