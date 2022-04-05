import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

public class Starting extends ProSetting {
	public MyPanel panel;
	public JButton start;
	
	public Starting() {
		
		i = new ImageIcon("src/img/main.png");
		im = i.getImage();
		
	    panel = new MyPanel();
	    
	    start = new JButton("", btnNomal);
	    start.setRolloverIcon(btnOver);
	    start.setPressedIcon(btnClick);
	    start.setContentAreaFilled(false);
	    start.setBorderPainted(false);
	    start.setFocusPainted(false);
	    start.setBorder(BorderFactory.createEmptyBorder(300, 0, 0, 0));
	    
	    panel.add(start);
	    
	}
	
	public void setVisible(boolean tf) {
		panel.setVisible(tf);
		
	}
	
}