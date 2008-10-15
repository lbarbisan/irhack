package Link;

import Utils.Point;
import Interface.IrhackUI;
import Game.*;
import Game.Elements.*;


public class Controleur {
  	private Donjon donjon;
  	private IrhackUI ui;
  	private Linktable link;

  	public Controleur() {
		// Fenetre de creation controleur */
		  		
		this.donjon = new Donjon(this);
		this.link = new Linktable();
		this.ui = new IrhackUI(this, link);

		/* Démarre la partie et affichage */
		ui.setVisible(true);
		this.donjon.Play();	
  	}

	/********************************************* Fonctions faisant le lien de Donjon à Interface **********************************************************/
	
	public Integer[][] getGraphe() {
		Cellule[][] cellule = donjon.getCellules();
		Integer[][] cell = new Integer[cellule.length][cellule[0].length];
		
		for( int l = 0 ; l < cellule.length ; l++ ) {
			for( int c = 0 ; c < cellule[l].length ; c++) {
				Occupant occ = cellule[l][c].getOccupant();	
				if(occ == null)
					cell[l][c] = null;
				else
					cell[l][c] = link.getNum(occ.getClass().getName());
			}
		}
		
		return cell;	
	}

	public void refreshAll() {
		refreshGraphe();
		//refreshInfo();
	}

	public void refreshGraphe() {
		ui.refreshGraphe();
	}

	public void refreshInfo( String[] value ) {
		ui.refreshInfo( value );		
	}

	public void printMsg( String msg ) {
		ui.printMsg(msg);
	}


	public void setUserInterraction(boolean b) {
		ui. setListenerActived(b);
	}


	/********************************************* Fonctions faisant le lien de Interface à Donjon **********************************************************/

	public void setSource( Point p) {
		donjon.setSource(p);
	}

	public void setDestination(Point p) {
		donjon.setDestination(p);
	}

	public void doAction( String action) {
		donjon.doAction(action);
	}

	public String[] getActions() {
		return donjon.getActions();
	}

	public String[]  getList(String classname)
	{
		return null;
	}
	
}