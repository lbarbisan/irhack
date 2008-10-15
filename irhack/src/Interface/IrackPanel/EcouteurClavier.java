package Interface.IrackPanel;

import Interface.IrhackUI;
import java.awt.event.*;
import Utils.Point;

public class EcouteurClavier implements KeyListener{
	private IrhackUI ui;

  	public EcouteurClavier(IrhackUI ui) {
		this.ui = ui;
  	}

  	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		
		/* L'aventurier est la source par defaut */		
		ui.setSource(new Point(-1,-1, Point.TYPE_NUM));

		switch(code) {
	  		case KeyEvent.VK_DOWN  : ui.doAction("Descendre");
			   break;
			case KeyEvent.VK_NUMPAD2  :  ui.doAction("Descendre");
			   break;
	  		case KeyEvent.VK_UP    :  ui.doAction("Monter");
			   break;
			case KeyEvent.VK_NUMPAD8    :  ui.doAction("Monter");
			   break;
	  		case KeyEvent.VK_LEFT  : ui.doAction("Gauche");
			   break;
			case KeyEvent.VK_NUMPAD4  :  ui.doAction("Gauche");
			   break;
	  		case KeyEvent.VK_RIGHT : ui.doAction("Droite");
			   break;
			case KeyEvent.VK_NUMPAD6 :  ui.doAction("Droite");
			   break;
	  		default :
			   break;
				}
  	}

  	public void keyReleased(KeyEvent e) {}
  	public void keyTyped(KeyEvent e) {}
}