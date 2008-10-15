package Interface.IrackPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Interface.IrhackUI;

public class PopMenuListener implements ActionListener {
	private IrhackUI ui;
 
 	/*Constructeur*/
 	public  PopMenuListener(IrhackUI ui) {
	 	this.ui = ui;
	} 

	/* Execution d'une actions */
	public void actionPerformed(ActionEvent e) {
		ui.doAction(e.getActionCommand());
	}
}
