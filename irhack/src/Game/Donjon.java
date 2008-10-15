package Game;

import Game.Elements.*;
import Link.Controleur;
import Utils.*;
import java.util.Iterator;

public class Donjon {
 	
 	private Salle salleCourante; 			/* Salle actuelle */
  	private HistorySalle hSalle;			/* Historique des salle */
  	public Controleur controleur;
  	private Creature creatureSource;
  	private Creature creatureDestination;
	private Meuble meubleSource;
	private Meuble meubleDestination;
	
	private Aventurier perso;				/* Aventurier */

	public Donjon(Controleur controleur) {
		this.hSalle = new HistorySalle();
		this.salleCourante = new Salle(new Position(0,0),hSalle, this);
		this.perso = new Aventurier(2,2,3,2,2,1, this.salleCourante.getCellule(1,1) , this);
		this.controleur = controleur;
  	}
  
  /* Change de salle dans le donjon */
	public void changerSalle(int NSEO) {
			Position pos = null;

			switch(NSEO) {
				case 1 : pos = new Position(salleCourante.getPosition().getAbs(),salleCourante.getPosition().getOrd()+1);
					break;
				case 2 : pos = new Position(salleCourante.getPosition().getAbs(),salleCourante.getPosition().getOrd()-1);
					break;
				case 3 : pos = new Position(salleCourante.getPosition().getAbs()+1,salleCourante.getPosition().getOrd());
					break;
				case 4 : pos = new Position(salleCourante.getPosition().getAbs()-1,salleCourante.getPosition().getOrd());
					break;
				default :
					break;
			}

			hSalle.addSalle(salleCourante);
			Salle salle = hSalle.getSalle(pos);

			if(salle == null)
				salle = new Salle(pos,hSalle, this);

			Cellule cellule = perso.getCellule();
			cellule.perdreOccupant(perso);
			((Porte)cellule.getMeuble()).getCellDest().prendreOccupant(perso);
			salleCourante = salle;
			salleCourante.CreatureList.add(this.getAventurier());
		}
  
  	/* Récupère l'aventurier */
  	public Aventurier getAventurier() {
  		return this.perso;
  	}
  	
  	public void setAventurier(Aventurier aventurier)
  	{
  		this.perso = aventurier;
  	}
  
  /*renvoi la salle courante */
	public Salle getSalleCourante() {
		return this.salleCourante;
	} 
	
	/* Lance le donjon */
	public void Play() {
	
		int Stop = 1;
		Creature creature;
		salleCourante.CreatureList.add(this.getAventurier());
		
		while(Stop!=0)
		{	
			/* Tri les creature par Initiative */
			this.print("=======Nouveau Round=======");	
			java.util.Collections.sort(salleCourante.CreatureList, new CreatureComparator());
			this.setDestination(new Point (-1, -1, Point.TYPE_NUM));
			
			/* Les faits jouer */
			for(Iterator i = salleCourante.CreatureList.iterator() ; i.hasNext();)
			{
				
				creature = (Creature)i.next();
				/*Vérifit que la créature vivante est vivante */
				if(creature.getCellule()!=null)
				{
					if((creature.PV.Get_Value())<0)
						creature.getCellule().perdreOccupant(creature);	
					else
						creature.ActionRestante = (int)creature.V.Get_Value();
						creature.doAction("p_Jouer",this);
				}
				if(this.getAventurier().PV.Get_Value()<0)
					Stop=0;
			}
		}
		System.out.println("Jeu Terminé");
	}
	
	/*==============================F O N C T I O N S  C O N T R O L E U R S============================*/
	
	
	/* Selectionne la source Active */
	public void setSource(Point p)
	{
		/* Récuperation de la créature */
		this.meubleSource=null;
		this.creatureSource=null;
		
		if(p.getLigne()==-1 && p.getColonne()==-1)	
			this.creatureSource = perso;
		else
		{
		Creature creature = salleCourante.getCellule(p.getLigne(), p.getColonne()).getCreature();
		if(creature!=null)
				this.creatureSource = creature;
		
		/* Récuperation d'un objet */
		Meuble meuble = salleCourante.getCellule(p.getLigne(), p.getColonne()).getMeuble();
		this.meubleSource = meuble;
		}

	}
	
	/*  Selectionnne la destination Active */
	public void setDestination(Point p)
		{
			/* Récuperation de la créature */
			this.creatureDestination = null;
			this.meubleSource = null;
			
			if(p.getLigne()==-1 && p.getColonne()==-1)
				this.creatureDestination = perso;
			else
			{
					Creature creature = salleCourante.getCellule(p.getLigne(), p.getColonne()).getCreature();
					if(creature!=null)
						this.creatureDestination = creature;
					else
						this.creatureDestination = perso;

					/* Récuperation d'un objet */
					Meuble meuble = salleCourante.getCellule(p.getLigne(), p.getColonne()).getMeuble();
					this.meubleDestination = meuble;
			}
		}
	
	/* Renvoi la listes des actions */
	public String[] getActions()
	{
		String[] strCreature = null;
		String[] strMeuble = null;
		String[] strFinale = null;
		int Length=0;
		int lenCreature=0, lenMeuble=0;
		int Start=0;
		int index=0;
		
		if(this.creatureSource!=null)
		{
			strCreature =  this.creatureSource.getUserInteractions(this.creatureDestination);
			lenCreature = strCreature.length;
			Length += lenCreature +1;
		}
		if(this.meubleSource!=null)
		{	
			strMeuble = this.meubleSource.getUserInteractions(this.creatureDestination);
			lenMeuble  = strMeuble.length;
			Length += lenMeuble +1;			
		}
		
		strFinale = new String[Length];
		if(this.creatureSource!=null)
		{
				strFinale[0] = "[Creature]";
			for(index=1; index<=lenCreature;index++)
					strFinale[index] = strCreature[index-1];
		}
		
		if(this.meubleSource!=null)
		{
			strFinale[index] = "[Meuble]" ; Start = ++index;
			for(index=0;index<lenMeuble;index++)
						strFinale[Start+index] = strMeuble[index];
		}
					
		return strFinale;
	}
	
	/* Fait une actions */
	public void doAction(String Action)
	{
		if(this.creatureSource!=null)
			this.creatureSource.doAction(Action, this.creatureDestination);
		if(this.meubleSource!=null) 
			this.meubleSource.doAction(Action, this.creatureDestination);

		controleur.refreshGraphe();
	}
	
	/* Renvoi la matrice de cellules */
	public Cellule[][] getCellules()
	{
		return this.getSalleCourante().getCellules();
	}
	
	public void SetUserPlay(boolean activated)
	{
		controleur.setUserInterraction(activated);
	}
	
	/* Renvoi la distance entre deux elements */
	public static int Distance(Occupant Source, Occupant Destination)
	{
		int Hauteur;
		int Longueur;
	
		Longueur = Math.abs(Source.getCellule().p.getColonne() - Destination.getCellule().p.getColonne());
		Hauteur = Math.abs(Source.getCellule().p.getLigne()- Destination.getCellule().p.getLigne());
		return (int)Math.sqrt(Longueur * Longueur + Hauteur * Hauteur);
	}
	
	/*renvoi la direction à prendre pour rejoindre une destination */
	public static int Direction(Occupant source, Occupant destination)
	{
		int Hauteur;
		int Longueur;
	
		Longueur = destination.getCellule().p.getColonne() - source.getCellule().p.getColonne(); 
		Hauteur = destination.getCellule().p.getLigne() -source.getCellule().p.getLigne();
		if(Math.abs(Hauteur) >Math.abs(Longueur))
		{		
			if(Hauteur<0)
				return 1;
			else if(Hauteur>0)
				return 2;
		}
		else if(Math.abs(Hauteur)<Math.abs(Longueur))
		{
			if(Longueur<0)
					return 4;
			else if(Longueur>0)
					return 3;
		}
		return 5;			
	}
	
	  public static boolean DecrementActions(Mobile source)
	   {
			if((source.ActionRestante--)<=0)
					return false;
				return true;
	   }
	   
	   public void refreshAttribut(String[] attribut)
	   {
	   		controleur.refreshInfo(attribut);
	   }
	   
	public void print( String msg ) {
			controleur.printMsg(msg);
	}
}