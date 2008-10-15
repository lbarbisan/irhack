package Interface.IrackPanel;

import java.awt.event.*;
import java.awt.PopupMenu;  
import java.awt.*;
import Interface.*;
import Utils.Point;

public class EcouteurSouris implements MouseListener {
	private Component component;
	private IrhackUI ui;
	
	public EcouteurSouris( Component component, IrhackUI ui ) {
		this.component = component;
		this.ui = ui;
	}
	
	public void mouseClicked(MouseEvent e) {
		String[] actions;
		Point p = new Point( e.getY() , e.getX(), Point.TYPE_PX);
		PopupMenu menu = new PopupMenu();
		ui.add(menu);
		
		if(e.getButton() == e.BUTTON3 && !e.isConsumed()) {
			ui.setSource(p);
			actions = ui.getActions();
			
			int index;
	 		for(index=0;index<actions.length;index++)
	 			menu.add(actions[index]);
			if(index>0)
			{
				menu.addActionListener( new PopMenuListener(ui));
				menu.show(component, e.getX() , e.getY());
			}
		}
		else if(e.getButton() == e.BUTTON1 && !e.isConsumed())
			ui.setDestination(p);

		e.consume();
	}

	public void mouseExited(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
}
