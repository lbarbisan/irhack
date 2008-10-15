/*
 * Créé le 9 févr. 2004
 *
 * Pour changer le modèle de ce fichier généré, allez à :
 * Fenêtre&gt;Préférences&gt;Java&gt;Génération de code&gt;Code et commentaires
 */
package Game.Elements;

/**
 * @author lbarbisa
 *
 * Pour changer le modèle de ce commentaire de type généré, allez à :
 * Fenêtre&gt;Préférences&gt;Java&gt;Génération de code&gt;Code et commentaires
 */
import Game.*;
import Game.Interactions.*;

public class Monstre extends Creature {
	
	
/* Constructeur */
public Monstre(int Vitesse, int Endurance, int Attaque, int Defense, int XP, int Niv, Cellule cellule, Donjon donjon) {
	super(Vitesse, Endurance, Attaque, Defense, XP, Niv, cellule, donjon);
	this.nom = "Monstre";
	this.description = "Ho!! un monstre";
	actions = new ActionsManager(this);
  }

public void Attaquer( Creature Source, Creature Destination)
{
	  Source.doAction("p_Attaquer", Destination);	 
 }
 
public void p_Jouer(Monstre Source, Donjon Destination)
{
	
	while(Donjon.DecrementActions(Source)!=false)
	{
		if(Donjon.Distance(Source, Destination.getAventurier())==1)
		{
			Destination.getAventurier().doAction("Attaquer", Source);
		}
		switch(Donjon.Direction(Source, Destination.getAventurier()))
		{	
			case 1: 
			Source.doAction("p_gotoNord", Source);
			break;
			case 2:
			Source.doAction("p_gotoSud", Source); 
			break;
			case 3: 
			Source.doAction("p_gotoEst", Source);
			break;
			case 4: 
			Source.doAction("p_gotoOuest", Source);
			break;
		}
		Destination.controleur.refreshGraphe();
	}
}
  
}
