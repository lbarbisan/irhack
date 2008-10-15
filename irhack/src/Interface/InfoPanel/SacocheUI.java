package Interface.InfoPanel;

import javax.swing.*;
import java.awt.*;

public class SacocheUI extends JPanel {
	String name;

	public SacocheUI() {
		name = "Sacoche";
		
		this.setLayout(new BorderLayout());
		
		this.add(new JLabel("Truc Sacoche"),BorderLayout.CENTER);
	}

	public String getName() {
		return this.name;
	}	
}
