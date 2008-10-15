package Game.Elements;

import Game.Cellule;
import Game.Donjon;
import Game.Contenaires.*;
import Game.Interactions.*;
import Game.Modificateurs.*;

public abstract class Creature extends Mobile {

  /* P R O P R I E T E S */
  public Attribut PV; // Point de vie
  public Attribut E; // Endurance
  public Attribut V; // Vitesse
  public Attribut XP; // Point d'experience
  public Attribut VA; // Valeur d'attaque
  public Attribut VD; // Valeur de défense
  public Attribut Blessure;
  public Attribut Niveau;
  protected AttributsManager Attributs;
 
  /* Constructeur */
  public  Creature(int Vitesse, int Endurance, int Attaque, int Defense, int XP, int Niv, Cellule cellule, Donjon donjon) {
	super(cellule, donjon);

	/* Création des attributs*/
	this.Blessure = new Attribut(0);
	this.Niveau = new Attribut(Niv);
	this.XP = new Attribut(XP);
	
	/* Endurance = Base + Niveau */
	this.E = new Attribut(Endurance); this.E.Add_Mod(this.Niveau);
	
	/* Valeur Attaque = Base + (Niveau+1)/2 */
	this.VA = new Attribut(Attaque);
	this.VA.Add_Mod(
		new ModificateurDiv(
			new ModificateurAdd(this.Niveau,new Modificateur(1)), new Modificateur(2)));
	
	/* Vitesse : base + Niveau/5 */
	this.V = new Attribut(Vitesse); this.V.Add_Mod(new ModificateurDiv(this.Niveau, new Modificateur(5)));
	
	/* Valeur Defense : base + Niveau/2 */
	this.VD = new Attribut(Defense); this.VD.Add_Mod(new ModificateurDiv(this.Niveau, new Modificateur(2)));
	
	/* Les points de vies sont égaux à 4*Endurance - les blesures */
	this.PV = new Attribut(0); this.PV.Add_Mod(new ModificateurMult(new Modificateur(4), this.E));
	this.PV.Add_Mod(new ModificateurSous(new Modificateur(0), Blessure));
	
	/* Création des actions du personnage */
	actions = new ActionsManager(this);
	Attributs = new AttributsManager(this);
  }

/* Constructeur par copie*/
public Creature(Creature creature)
{
	super(creature.cellule, creature.donjon);
	creature.ActionRestante = this.ActionRestante;
	creature.actions = this.actions;
	creature.Blessure = creature.Blessure;
	creature.E = this.E;
	creature.cellule = this.cellule;
	creature.description = this.description;
	creature.Main_Droite = this.Main_Droite;
	creature.Main_Gauche = this.Main_Gauche;
	creature.Niveau = this.Niveau;
	creature.nom = this.nom;
	creature.PV = this.PV;
	creature.Sac = this.Sac;
	creature.V = this.V;
	creature.VA =this.VA;
	creature.VD = this.VD;
	creature.Veste = this.Veste;
	creature.XP = this.XP;
}


  /* E Q U I P E M E N T S*/
  public Contenaire Main_Gauche = new Contenaire("Game.Elements.AbstractBouclier", 1);
  public Contenaire Main_Droite = new Contenaire("Game.Elements.AbstractArme", 1);
  public Contenaire Sac = new Contenaire("Game.Elements.Objet", 10);
  public Contenaire Veste = new Contenaire("Game.Elements.AbstractVetement", 1);

  /*F O N C T I O N*/
  
  /* Affichage des caractéristiques */
  public String toStringAttributs(){
	return "PV:" + PV.Get_Value() + "\n"
		+ "E:" + E.Get_Value() + "\n"
		+ "VA:" + VD.Get_Value() + "\n"
		+ "VD:" + VA.Get_Value() + "\n"
		+ "XP:" + XP.Get_Value() + "\n"
		+ "V:" + XP.Get_Value() + "\n"
		+ "N:" + Niveau.Get_Value() + "\n";
	
  }
  
  
  /* A C T I O N */
public void p_Attaquer( Creature Source, Creature Destination) {
	  /* Tirage du Dées */	
	long Result;
	int Des;
	if(Donjon.Distance(Source, Destination)>1){
		Source.getDonjon().print("La cible est trop loin");
			return;
	}
	Des = (int)(Math.random()*10) +1;
	Result = Destination.VA.Get_Value() + Des;
	Result -= Source.VD.Get_Value() + 5;
	
	/* Essaye d'attaquer */
	Donjon.DecrementActions(Destination);
	if(Result>0)
		  {
			 Source.Blessure.Add_Mod(new Modificateur((int)Result));
			 Source.getDonjon().print(Source.nom + " Blessure: -" + Result);
		if(Source.PV.Get_Value()<0)
		{
			Destination.XP.Add_Mod(new Modificateur(1));	
			Source.getCellule().perdreOccupant(Source);
		}
	  }
	else
	 	Source.getDonjon().print("L'attaque a échouée");
}

  
}