/*
 * Créé le 16 févr. 2004
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
import Game.Modificateurs.*;

public class Guerrier extends Aventurier {
	
	public Guerrier(Aventurier aventurier)
	{
		super(aventurier);
		
		/* Application des nouveau modificateur */
		int Base = this.VA.getBase();
		this.VA = new Attribut(Base);
		this.VA.Add_Mod(this.Niveau);
		
		/* Application de l'endurance */
		Base = this.E.getBase();
		this.E = new Attribut(Base);
		this.E.Add_Mod(new ModificateurDiv(new ModificateurMult(new Modificateur(3), this.Niveau),new Modificateur(2)));
	}

	public void Charger(Creature Source, Creature Destination) {
		/* Tirage du Dées */
		long Result;
		Modificateur ModChargeVA = new Modificateur((int)(Source.VA.Get_Value()));
		Modificateur ModChargeVD = new Modificateur(-5);
		
		/*Ajoute des modificateurs de charge */
		Source.VA.Add_Mod(ModChargeVA);
		Source.VD.Add_Mod(ModChargeVD);
		
		this.doAction("p_Attaquer", Destination);
		
		/* Suppresion des modificateurs */
		Source.VA.Del_Mod(ModChargeVA);
		Source.VD.Del_Mod(ModChargeVD);
		
	}

}
