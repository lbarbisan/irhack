package Interface.Menus;

import javax.swing.*;
import java.awt.event.*;
import Interface.IrhackUI;

public class Menu extends JMenuBar{
 	private EcouteurMenu listener;
  	private JMenu fichier,option,aide;
  	private JMenuItem nouveau,nouveau2,fermer,quitter,apropos;

  public Menu(IrhackUI ui) {
    listener = new EcouteurMenu(ui);

    fichier = new JMenu("File");
    aide = new JMenu("Help");

    add(fichier);
    add(aide);

    nouveau = new JMenuItem("New Training");
    nouveau.setMnemonic('T');
    nouveau.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,InputEvent.CTRL_MASK));
    nouveau.addActionListener(listener);

    nouveau2 = new JMenuItem("Rush Hour");
    nouveau2.setMnemonic('R');
    nouveau2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,InputEvent.CTRL_MASK));
    nouveau2.addActionListener(listener);

    fermer = new JMenuItem("Close");
    fermer.setMnemonic('C');
    fermer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_MASK));
    fermer.addActionListener(listener);

    quitter = new JMenuItem("Exit");
    quitter.setMnemonic('E');
    quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,InputEvent.CTRL_MASK));
    quitter.addActionListener(listener);

    fichier.add(nouveau);
    fichier.add(nouveau2);
    fichier.add(fermer);
    fichier.addSeparator();
    fichier.add(quitter);

    apropos = new JMenuItem("A propos");
    apropos.addActionListener(listener);

    aide.add(apropos);
  }
}