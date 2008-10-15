package Interface.CommentPanel;

import javax.swing.*;
import java.awt.*;

public class CommentPanel  extends JPanel {
	JTextArea area = new JTextArea();

	public CommentPanel() {
		super();
		area.setBackground(SystemColor.inactiveCaptionText);
		area.setEnabled(true);
		area.setFont(new java.awt.Font("DialogInput", 0, 12));
		area.setBorder(BorderFactory.createLoweredBevelBorder());
		area.setDisabledTextColor(Color.black);
		area.setEditable(false);
		area.setText("");
		area.setLineWrap(true);
		area.setMinimumSize(new Dimension(650, 50));
		area.setPreferredSize(new Dimension(650, 50));
		area.setMaximumSize(new Dimension(650, 50));
		add(area, BorderLayout.CENTER);
	}

	public void addLine(String msg) {
		String intro = ">  ";
		area.setText( intro + msg +"\n"+ area.getText() );
	}

	public Dimension getPreferredSize() {
		return new Dimension(0,60);
	}
}
