/*
 * Cr�� le 24 f�vr. 2004
 *
 * Pour changer le mod�le de ce fichier g�n�r�, allez � :
 * Fen�tre&gt;Pr�f�rences&gt;Java&gt;G�n�ration de code&gt;Code et commentaires
 */
package Game.Elements;

/**
 * @author lbarbisa
 *
 * Pour changer le mod�le de ce commentaire de type g�n�r�, allez � :
 * Fen�tre&gt;Pr�f�rences&gt;Java&gt;G�n�ration de code&gt;Code et commentaires
 */
import Game.*;
import  Game.Interactions.*;

public class Fprofession extends Fontaine {

	/* (non-Javadoc)
	 * @see Game.Elements.Fontaine#Boire(Game.Elements.Fontaine, Game.Elements.Creature)
	 */
	public Fprofession(Cellule cellule)
	{
		super(cellule);
		this.nom = "Fontaine de profession";
		this.description = "change les professions";
	
		actions = new ActionsManager(this);
	}
	
	
public void Boire(Fontaine Source, Creature Destination) {
		int Profession;
		/*Profession = (int)Math.random()*4 +1;*/
		
		if(Used==0)
		{
			Profession = 0;
			switch(Profession)
			{
				case 0:		 	
				Destination.getDonjon().setAventurier( new Guerrier( Destination.getDonjon().getAventurier()));
				break;
				case 1:			
				break;
				case 2:			
				break;
				case 3:			
				break;
			}
			Used++;
		}

	}
}
