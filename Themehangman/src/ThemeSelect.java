import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

public class ThemeSelect extends ProSetting {
	public MyPanel panel;
	public JButton btn[];
	
	public ThemeSelect() {

		i = new ImageIcon("src/img/screenback.png");
		im = i.getImage();
		
	    panel = new MyPanel();
	    
	    JPanel subpanel = new JPanel();
	    subpanel.setBackground(transparent);
	    subpanel.setBorder(BorderFactory.createEmptyBorder(60, 0, 0, 0));
	    
		ImageIcon btnNomal[] = new ImageIcon[3];
		btnNomal[0] = new ImageIcon("src/img/btns/btn1_1.png");
		btnNomal[1] = new ImageIcon("src/img/btns/btn2_1.png");
		btnNomal[2] = new ImageIcon("src/img/btns/btn3_1.png");
		
		ImageIcon btnOver[] = new ImageIcon[3];
		btnOver[0] = new ImageIcon("src/img/btns/btn1_2.png");
		btnOver[1] = new ImageIcon("src/img/btns/btn2_2.png");
		btnOver[2] = new ImageIcon("src/img/btns/btn3_2.png");
		
		ImageIcon btnClick[] = new ImageIcon[3];
		btnClick[0] = new ImageIcon("src/img/btns/btn1_3.png");
		btnClick[1] = new ImageIcon("src/img/btns/btn2_3.png");
		btnClick[2] = new ImageIcon("src/img/btns/btn3_3.png");

		JPanel btns = new JPanel(new GridLayout(2,2,50,30));
	    btn = new JButton[3];
	    
	    for(int i=0; i<btn.length; i++) {
	    	btn[i] = new JButton(btnNomal[i]);
	    	btn[i].setRolloverIcon(btnOver[i]);
	    	btn[i].setPressedIcon(btnClick[i]);
	    	btn[i].setBorderPainted(false);
	    	btn[i].setFocusPainted(false);
	    	btn[i].setContentAreaFilled(false);
	    }
	    
		for(int i=0; i<btn.length; i++) {
			btns.add(btn[i]); 
		}
	    
	    subpanel.add(btns);
	    
	    panel.add(subpanel);
	}
	
	public void setVisible(boolean tf) {
		panel.setVisible(tf);
		
	}
}