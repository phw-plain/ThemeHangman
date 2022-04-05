import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

public class Playing extends ProSetting {
	public MyPanel panel;

	char ch[] = {
			'��', '��', '��', '��', '��',
			'��', '��', '��', '��', '��',
			'��', '��', '��', '��',
			'��', '��', '��', '��', '��',
			'��', '��', '��', '��', '��'	
	};
	
	public Playing() {
		
		i = new ImageIcon("src/img/background.png");
		im = i.getImage();
		
	    panel = new MyPanel();
	    
	    JPanel typing = new JPanel(new GridLayout(5, 5, 5, 5));
	    typing.setBackground(background);
	    typing.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));
	    JButton keyboard[] = new JButton[ch.length];
	    for(int i=0; i<ch.length; i++) {
	    	if(i == 14) {
	    		// blank
	    		JLabel blank = new JLabel("");
		    	typing.add(blank);
	    		
	    	} 
	    	keyboard[i] = new JButton(String.valueOf(ch[i]));
	    	keyboard[i].setFont(font1);
	    	keyboard[i].setBackground(key);
	    	keyboard[i].setContentAreaFilled(true);
	    	keyboard[i].setBorderPainted(true);
	    	keyboard[i].setFocusPainted(false);
	    	keyboard[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		    typing.add(keyboard[i]);
	    }
	    
	    JPanel question = new JPanel(new GridLayout(1, 5));
	    JLabel text[];
	    
	    // replace�̿��ؼ� �迭 stage �̹��� ����� 350x300px �� �����
		ImageIcon stage = new ImageIcon("src/stage/stage1.png");
	   
		JButton screen = new JButton(stage);
		screen.setContentAreaFilled(false);
		screen.setBorderPainted(false);
		screen.setFocusPainted(false);
		screen.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));

	    panel.add(screen);
	    panel.add(typing);
	}

	public void setVisible(boolean tf) {
		panel.setVisible(tf);
	}
	
		
}