package Game;

import java.util.*;
import Utils.Utils;
import Utils.Position;
import Game.Elements.*;
import Utils.Point;

public class Salle {
	private final static int NB_LIGNE_MIN_SALLE = 15; 
	private final static int NB_LIGNE_MAX_SALLE = 15; 
	private final static int NB_COLONNE_MIN_SALLE = 15; 
	private final static int NB_COLONNE_MAX_SALLE = 15;
	private final static int NB_MEUBLE_MAX = 5;
		
	private int nbLigne;						/* Taille de la salle */
	private int nbColonne;					/* Taille de la salle */
	private Cellule cellules[][];			/* Tableau de cellule */
	private Portes portes;					/* Listes des portes */
	private Position pos;						/* Repère absolue de la salle */
	public LinkedList CreatureList;			/* Liste des monstres trié par VItesse */

		
	/* Constructeur */
	public Salle(Position pos, HistorySalle hSalle, Donjon donjon) {
		
		this.nbLigne = Utils.randomImpaire(Salle.NB_LIGNE_MIN_SALLE,Salle.NB_LIGNE_MAX_SALLE) + 2;
		this.nbColonne = Utils.randomImpaire(Salle.NB_COLONNE_MIN_SALLE,Salle.NB_COLONNE_MAX_SALLE) + 2;
		this.pos = pos;
		
		this.cellules = new Cellule[this.nbLigne][this.nbColonne];
		this.portes = new Portes();		

		CreatureList = new LinkedList();

		initSalle(cellules,hSalle,portes, donjon);
	}
	
	/* Création d'une salle */
	private void initSalle(Cellule cellules[][], HistorySalle hSalle, Portes portes, Donjon donjon) {
	  	// Creation des cellules
	 	for (int l=0 ; l<nbLigne ; l++)
			for (int c=0 ; c<nbColonne ; c++)
		  		{
		  			cellules[l][c] = new Cellule(new Point(l,c , Point.TYPE_NUM));
		  		}

	  	// Liaisons des cellules interieures
	  	for (int l=0 ; l<nbLigne ; l++)
			for (int c=0 ; c<nbColonne ; c++) {
				if(l != 0) cellules[l][c].setNord(cellules[l-1][c]);
		  		if(c != 0) cellules[l][c].setOuest(cellules[l][c-1]);
		  		if(c != nbColonne-1) cellules[l][c].setEst(cellules[l][c+1]);
		  		if(l != nbLigne-1) cellules[l][c].setSud(cellules[l+1][c]);
			}

		// Initialisation des portes de la salle.		
		placePortes(cellules,hSalle,portes);

		// Mise en place des murs autour de la salle
		placeMurs(cellules);
		
		// Initialisation des Fontaines obstacles dans la salle.
		placeMeubles(cellules);

		// Initialisation des Mobiles 
		placeMobiles(cellules, donjon);

		// Initialisation des murs obstacles dans la salle.
		placeObstacles(cellules);
		
	}

	/* Place les murs */
	private void placeMurs(Cellule cellules[][]) {
		for(int l=0; l<nbLigne; l++) {
			for(int c=0; c<nbColonne; c++) {
				if( l == 0 || l == nbLigne-1 || c == 0 || c == nbColonne-1)
					new Mur(cellules[l][c]);
			}
		}
	}
		
	/* Place des obstacles */
	private void placeObstacles(Cellule cellules[][]) {
		int nbObs = Utils.random(5,10);

		for(int i=0 ; i<nbObs ; i++) {
			Cellule cellule = cellules[Utils.random(2,nbLigne-2)][Utils.random(2,nbColonne-2)];
			if(cellule.estLibreFixe())
				new Mur(cellule);
		}
	}

	/* Place des Mobile */
	private void placeMobiles(Cellule cellules[][], Donjon donjon)
	{
		Monstre monstre;
		/* Ajout de l'objet */
		int nbObs = Utils.random(0,NB_MEUBLE_MAX+6);
				for(int i=0 ; i<nbObs ; i++) {
					Cellule cellule=cellules[Utils.random(2,nbLigne-2)][Utils.random(2,nbColonne-2)];
					if(cellule.estLibreCreature())
					{ 
					 	monstre = new Monstre(Utils.random(1,3), Utils.random(1,3), 1 ,Utils.random(1,3) ,1 ,1, cellule, donjon);
					 	this.CreatureList.add(monstre);
					}
				}
		
	}

	/* Place des Meubles */
	private void placeMeubles(Cellule cellules[][]) {
		int nbObs = Utils.random(0,NB_MEUBLE_MAX+1);
		for(int i=0 ; i<nbObs ; i++) {
			Cellule cellule = cellules[Utils.random(2,nbLigne-2)][Utils.random(2,nbColonne-2)];
			if(cellule.estLibreMeuble()) {
				switch(Utils.random(0,4)) {
					case 0 :	new Jade(cellule);
						break;
					case 1 :	new Benite(cellule);
						break;
					case 2 :	new Pile(cellule);
						break;
					case 3 : 	
					System.out.println("dfsdf");
									new Fprofession(cellule);
					default :
						break;
				}					
			}
		}
	}

	
	// On replace les portes des salles déjà existante et adjacente.
	private void placePortes(Cellule cellules[][], HistorySalle hSalle, Portes portes) {
		Salle salleAdj;
		boolean hasNouvellePorte = false;
		
		// Salle Ouest.
		salleAdj =  hSalle.getSalle(new Position(this.pos.getAbs()-1,this.pos.getOrd()));
		hasNouvellePorte = placePorteAdjEtLibre(cellules,portes,salleAdj,hasNouvellePorte,4);		

		// Salle Est.
		salleAdj =  hSalle.getSalle(new Position(this.pos.getAbs()+1,this.pos.getOrd()));
		hasNouvellePorte = placePorteAdjEtLibre(cellules,portes,salleAdj,hasNouvellePorte,3);		

		// Salle Nord.
		salleAdj =  hSalle.getSalle(new Position(this.pos.getAbs(),this.pos.getOrd()-1));
		hasNouvellePorte = placePorteAdjEtLibre(cellules,portes,salleAdj,hasNouvellePorte,1);		

		// Salle Sud.
		salleAdj =  hSalle.getSalle(new Position(this.pos.getAbs(),this.pos.getOrd()+1));
		hasNouvellePorte = placePorteAdjEtLibre(cellules,portes,salleAdj,hasNouvellePorte,2);		

	}
	
	private boolean placePorteAdjEtLibre(Cellule cellules[][], Portes portes, Salle salleAdj, boolean hasNouvellePorte, int NSEO) {		
		if(salleAdj != null) {
			int NSEOAdj;
	
			if((NSEO % 2) == 1)
				NSEOAdj = NSEO+1;
			else
				NSEOAdj = NSEO-1;

			Porte porteAdj = salleAdj.getPortes().getPorte(NSEOAdj);
			if(porteAdj != null) {
				porteAdj.setSalleDest(this);
				portes.setPorte(cellules,NSEO);
				porteAdj.setCellDest(portes.getPorte(NSEO).getCellule());
				portes.getPorte(NSEO).setSalleDest(salleAdj);
				portes.getPorte(NSEO).setCellDest(porteAdj.getCellule());
			}
		}
		else
			hasNouvellePorte = placePorte(cellules,portes,hasNouvellePorte,NSEO);
			
		return hasNouvellePorte;
	}
	
	private boolean placePorte(Cellule cellules[][], Portes portes, boolean hasNouvellePorte, int NSEO) {
		if(!hasNouvellePorte || Utils.random(0,2) == 1) {
			portes.setPorte(cellules,NSEO);
			hasNouvellePorte = true;
		}
		
		return hasNouvellePorte;
	
	}
	
	/* Renvoi la matrice de cellules */
	public Cellule[][] getCellules()
	{
		return this.cellules;
	}
	
	public Cellule getCellule(int l, int c) {
		return this.cellules[l][c];	
	}
	
	public Position getPosition() {
		return this.pos;
	}

	public Portes getPortes() {
		return this.portes;
	}

	public int getLargeur() {
		return this.cellules.length;	
	}
	
	public int getLongueur() {
		return this.cellules[0].length;	
	}	
		
}