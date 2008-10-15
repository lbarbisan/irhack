package Interface.Menus;

import java.awt.event.*;
import Interface.IrhackUI;

public class EcouteurMenu implements ActionListener {
  	private IrhackUI ui;

  public EcouteurMenu(IrhackUI ui) {
    this.ui = ui;
  }

  public void actionPerformed(ActionEvent e) {
    String source = e.getActionCommand();

    if(source.equalsIgnoreCase("New Training")) {
		System.out.println("ok");
    }
    else if(source.equalsIgnoreCase("Rush Hour")) {
		System.out.println("ok");
    }
    else if(source.equalsIgnoreCase("Close")) {
		System.out.println("ok");
    }
    else if(source.equalsIgnoreCase("Exit")) {
		System.out.println("ok");
    }
    else if(source.equalsIgnoreCase("a propos")) {
		System.out.println("ok");
      //new FrameAPropos(cont.getLabyrinthePanel().getLabyrintheUI());
    }
  }
}