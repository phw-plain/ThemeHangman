import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

public class MainClass extends ProSetting {
	private Frame mainFrame;
	private JPanel subpanel;
	
	private Starting Start;
	private Playing Play;
	
	
	public MainClass() {
		// Frame 기본 세팅
		mainFrame = new Frame("ThemeHangman"); 
	    mainFrame.setSize(width, height);
		mainFrame.setLocationRelativeTo(null);
	    mainFrame.setResizable(adjustment);
	    mainFrame.setVisible(true);
	    mainFrame.addWindowListener(new WindowAdapter() {
	       public void windowClosing(WindowEvent windowEvent) {
	          System.exit(0);
	       }
	    });
	    mainFrame.setIconImage(img.getImage());

	    Start = new Starting();
	    Play = new Playing();
	    
	    Start.start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    Start.setVisible(false);
			    Play.reLoad();
			    Play.setVisible(true);
			}
		});
	    
	    subpanel = new JPanel(new CardLayout());
	    subpanel.add(Start.panel);
	    subpanel.add(Play.panel);
	    
	    Start.setVisible(true);
	    Play.setVisible(false);
	    
	    mainFrame.add(subpanel);
	    mainFrame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainClass();
		backsound();
	}

}
