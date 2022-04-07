import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class ProSetting {
	public int width = 500;
	public int height = 800;
	
	public boolean adjustment = false;
	
	public URL imageURL = MainClass.class.getClassLoader().getResource("TH.png");
	public ImageIcon img = new ImageIcon(imageURL);
	public ImageIcon i;
	public Image im;
	public ImageIcon btnNomal = new ImageIcon("src/img/nomal.png");
	public ImageIcon btnOver = new ImageIcon("src/img/over.png");
	public ImageIcon btnClick = new ImageIcon("src/img/click.png");

	public Font font1 = new Font("µÕ±Ù¸ð²Ã", Font.PLAIN, 20);
	
	public Color background = new Color(253, 159, 40);
	
	class MyPanel extends JPanel{   
	    public void paintComponent(Graphics g){
	        super.paintComponent(g);
	        g.drawImage(im,0,0,getWidth(),getHeight(),this);
	    }
	}
	
	public static void backsound() {
        File file = new File("src/music/test.wav");
        
        try {
            AudioInputStream stream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(stream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch(Exception e) {
            e.printStackTrace();
        }
	}
	
	public static void btnsound() {
        File file = new File("src/music/test.wav");
        
        try {
            AudioInputStream stream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(stream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch(Exception e) {
            e.printStackTrace();
        }
	}
}