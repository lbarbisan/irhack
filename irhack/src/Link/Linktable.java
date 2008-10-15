package Link;

import java.util.Hashtable;
import java.awt.*;
import Utils.*;

public class Linktable {
	private Hashtable link;								// Table stoquant les images
	private Color fonds;
	private Integer pos;
	
	public Linktable() {
		link = new Hashtable();
		pos = new Integer(0);
		init();
	}
	
	/* Ajoute toutes les images du jeu dans la table */
	private void init() {
		this.fonds = Color.BLACK;
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		this.addLink("Inconnu", Images.getImage( Config.URL + "pinguin.gif", kit ));	
		this.addLink("Game.Elements.Aventurier", Images.getImage( Config.URL + "pinguin.gif", kit ));	
		this.addLink("Game.Elements.Mur", Images.getImage( Config.URL + "murGlace.gif", kit ));	

		/* IMAGE A FAIRE */
		this.addLink("Game.Elements.Monstre", Images.getImage( Config.URL + "squelette.gif", kit ));	
		this.addLink("Game.Elements.Benite", Images.getImage( Config.URL + "Fontaine.jpg", kit ));
		this.addLink("Game.Elements.Fprofession", Images.getImage( Config.URL + "Fontaine.jpg", kit ));	
		this.addLink("Game.Elements.Pile", Images.getImage( Config.URL + "piece.gif", kit ));	
		this.addLink("Game.Elements.Jade", Images.getImage( Config.URL + "Fontaine.jpg", kit ));	
		this.addLink("Game.Elements.Cle", Images.getImage( Config.URL + "ourson.gif", kit ));	
	}
	
	/* Ajoute un image dans la table referencé par le nom de sa classe */
	public void addLink( String classe, Image img ) {
		link.put(classe, pos);
		link.put(pos, img);
		increment();
	}
	  	
	/* Retourne l'image correspondant au numéro */
	public Integer getNum( String classe ) {
		return (Integer) link.get( classe );
	}
  	
	/* Retourne l'image correspondant au Integer */
	public Image getImage( Integer i ) {
		return (Image) link.get( i );
	}
	
	/* Retourne la couleur du fonds */
	public Color getFonds() {
		return this.fonds;
	}

	/* Retourne l'image correspondant à la classe */
	public Image getImage( String classe ) {
		return getImage( getNum( classe ) );
	}

	/* Incremente le Integer de 1 */
	private void increment() {
		pos = new Integer(pos.intValue() + 1);
	}
}