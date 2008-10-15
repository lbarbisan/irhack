package Interface.InfoPanel;

import javax.swing.*;
import java.awt.*;


public class InfoPanel extends JPanel {
  JTabbedPane tabbedpane;
  ButtonGroup group;
  
  SacocheUI sUI;
  EquipementUI eUI;
  PersonnageUI pUI;

  public InfoPanel() {
	this.setLayout(new BorderLayout());

	tabbedpane = new JTabbedPane();
	this.add(tabbedpane, BorderLayout.CENTER);

	this.sUI = new SacocheUI();	
	tabbedpane.add(sUI.getName(), sUI);

	this.eUI = new EquipementUI();	
	tabbedpane.add(eUI.getName(), eUI);
	
	this.pUI = new PersonnageUI();	
	tabbedpane.add(pUI.getName(), pUI);
	
	tabbedpane.setTabPlacement(JTabbedPane.TOP);
  	tabbedpane.setFocusable(false);
  }
  
  public void refreshPersonnage( String[] value) {
  	pUI.refresh(value);
  }
  
  public Dimension getPreferredSize() {
	  return new Dimension(150,0);
  }
}