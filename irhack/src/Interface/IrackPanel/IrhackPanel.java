package Interface.IrackPanel;

import javax.swing.*;
import java.awt.*;
import Interface.IrhackUI;
import Link.Linktable;
import Utils.*;

public class IrhackPanel extends JPanel {
  	private IrhackUI ui;
	private Linktable link;
	
	private EcouteurClavier clistener;
	private EcouteurSouris mlistener;

  	private int typeAffiche;

  	public IrhackPanel(IrhackUI ui, Linktable link) {
	   	// Initalisation des variables
		this.ui = ui;
		this.link = link;
    	typeAffiche = 0;
    	
		//	Création de l'écouteur clavier et souris
		this.clistener = new EcouteurClavier(ui);
		this.mlistener = new EcouteurSouris((Component)this, ui);
		
		this.setFocusable(true);
  	}

  	public void paintComponent(Graphics gr) {
   	 	super.paintComponents(gr);
    	Graphics2D g = (Graphics2D) gr;

    	switch(typeAffiche) {
      		case 0  : afficheGame(g);
                break;
      		default :
                break;
    	}
  	}

  	public void run() {
    	while(true)
      		this.repaint();
  	}

  	private void attente(Graphics2D g) {
    	g.setColor(link.getFonds());
    	g.fillRect(0,0,(int)getPreferredSize().getWidth(),(int)getPreferredSize().getHeight());
  	}

  	private void afficheGame(Graphics2D g) {
		attente(g);
		Integer[][] plateau = ui.getGraphe();
		
    	for(int i = 0 ;  i < plateau.length ; i++) {
      		for(int j = 0 ; j < plateau[i].length ; j++) {				
				if(plateau[i][j] != null ) {
					Image image =  link.getImage(plateau[i][j]);    		
					//System.err.println(" plateur != NULL  -  " + plateau[i][j] + " : " + image);
					if(image != null)
						//System.err.println("DRAW");
			            g.drawImage(image, j*Config.IMG_HAUT, i*Config.IMG_LARG, this);
				}
				//else
					//System.err.println(" plateur == NULL");
      		}
    	}
  	}

 	public void setTypeAffiche(int i) {
    	this.typeAffiche = i;
  	}

  	public Dimension getPreferredSize() {
		Integer[][] plateau = ui.getGraphe();
      	return new Dimension(plateau[0].length*Config.IMG_LARG,plateau.length*Config.IMG_HAUT);
  	}
  	
	/* Ajoute les listener */
	public void setListeners() {
		this.removeKeyListener(this.clistener);
		this.removeMouseListener(this.mlistener);
		this.addKeyListener(clistener);
		this.addMouseListener(this.mlistener);
		this.grabFocus();
	}

	/* supprime les listener */
	public void removeListeners() {
		this.removeKeyListener(this.clistener);
		this.removeMouseListener(this.mlistener);
	}
}