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
	    
	    JPanel subpanel = new JPanel(new BorderLayout());
	    subpanel.setBackground(new Color(255,255,255,0));
	    
	    JPanel btns = new JPanel(new BorderLayout());
	    btns.setBackground(new Color(255,255,255,0));
	    btns.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
	    JSlider sound = new JSlider();
	    sound.setBackground(new Color(253,159,40));
	    btns.add(sound, BorderLayout.EAST);
	    
	    sound.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                volume.setValue((float)((sound.getValue()-100) * 0.4));
            }
        });
	    
	    JPanel blank = new JPanel();
	    blank.setBorder(BorderFactory.createEmptyBorder(0, 0, 260, 0));
	    blank.setBackground(new Color(255,255,255,0));
	    
	    start = new JButton("", btnNomal);
	    start.setRolloverIcon(btnOver);
	    start.setPressedIcon(btnClick);
	    start.setBorderPainted(false);
	    start.setFocusPainted(false);
	    start.setBackground(new Color(238,238,238));
	    

	    subpanel.add(btns, BorderLayout.NORTH);
	    subpanel.add(blank, BorderLayout.CENTER);
	    subpanel.add(start, BorderLayout.SOUTH);
	    
	    panel.add(subpanel);
	    
	}
	
	public void setVisible(boolean tf) {
		panel.setVisible(tf);
		
	}
	
}