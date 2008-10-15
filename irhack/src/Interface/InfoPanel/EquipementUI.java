package Interface.InfoPanel;

import javax.swing.*;
import java.awt.*;

public class EquipementUI extends JPanel {
	String name;

	public EquipementUI() {
		name = "Equipement";
		
		this.setLayout(new BorderLayout());
		
		this.add(new JLabel("Truc Equipement"),BorderLayout.CENTER);
	}

	public String getName() {
		return this.name;
	}	
}
