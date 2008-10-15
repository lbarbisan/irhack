package Interface;

import javax.swing.*;
import java.awt.*;
import Link.*;
import Interface.IrackPanel.*;
import Interface.InfoPanel.*;
import Interface.CommentPanel.*;
import Utils.Point;

public class IrhackUI extends JFrame {
	private Controleur cont;
	private IrhackPanel irhackPan;
	private InfoPanel infoPan;
	private CommentPanel commentPan;

  	public IrhackUI(Controleur cont, Linktable link) {
		this.cont = cont;

		// Mise en forme des panels dans la fenetre
		Container pane = getContentPane();
		pane.setLayout(new BorderLayout());

		// Création et Ajout du champ graphique
		irhackPan = new IrhackPanel( this, link );
		pane.add(irhackPan,BorderLayout.CENTER);

		// Création et Ajout des onglets
		infoPan = new InfoPanel();
		pane.add(infoPan,BorderLayout.EAST);

		// Création et Ajout des commentaires
		commentPan = new CommentPanel();
		pane.add(commentPan,BorderLayout.SOUTH);

		// Menu et son ecouteur
		Interface.Menus.Menu menu = new Interface.Menus.Menu(this);
		setJMenuBar(menu);

		// Affichage de la fenetre
		setTitle("Irhack's Game");
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
  	}
  	
  	/********************************************************* Lien entre Interface et les Panels *****************************************************/
  	
	/* Raffraichi le graphe et ajoute un commentaire */
	public void refreshGraphe() {
		irhackPan.repaint();
	} 

	/* Raffraichi le graphe et ajoute un commentaire */
	public void refreshInfo( String[]value) {
		infoPan.refreshPersonnage( value );
	} 

	/* Ajoute une ligne dans les commentaires */
	public void printMsg( String msg ) {
	  	commentPan.addLine(msg);
	}
	
	public Integer[][] getGraphe() {
		return this.cont.getGraphe();
	}
	
	/* Active ou desactive les listener des panels */
	public void setListenerActived( boolean actived ) {
		
		if(actived)
			irhackPan.setListeners();
		else
			irhackPan.removeListeners();
	} 
	
	/******************************************************** Lien entre les Panels et Controleur ****************************************************/

	/* Retourne les actions associées */	
	public String[] getActions() {
		return cont.getActions();
	}

	public void setSource( Point p ) {
		cont.setSource(p);
	}

	public void setDestination( Point p ) {
		cont.setDestination(p);	
	}

	/* Effectue l'action voulue */
	public void doAction( String action) {
		cont.doAction(action);
	}
}