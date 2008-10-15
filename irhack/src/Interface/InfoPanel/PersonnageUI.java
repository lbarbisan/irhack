package Interface.InfoPanel;

import javax.swing.*;
import java.awt.*;

public class PersonnageUI extends JPanel {
	String name;
	JLabel label[] = new JLabel[10]; 

	public PersonnageUI() {
		name = "Personnage";
		
		/*this.setLayout(new BorderLayout());*/
		this.setLayout(new GridLayout(10,1));
		
		for(int i=0; i<10; i++)
		{
			this.label[i] = new JLabel();
			label[i].setMinimumSize(new Dimension(100, 100));
			label[i].setPreferredSize(new Dimension(100, 100));
			this.add(label[i]);
		}
	}

	public void refresh( String[] value ) {
		
		for(int i=0; i< value.length; i++)
		{
			label[i].setText("");
			label[i].setText(value[i] );
		}	
	}

	public String getName() {
		return this.name;
	}	
}
