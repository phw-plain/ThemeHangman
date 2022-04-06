import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class CircleButton extends JButton { 

	// color
	Color color1 = new Color(200, 200, 200);
	
	public CircleButton() { 
		super();
		decorate();
	} 
	
	public CircleButton(String text) { 
		super(text); 
		decorate();
	} 
	
	public CircleButton(Action action) { 
		super(action); 
		decorate();
	} 
	
	public CircleButton(Icon icon) { 
		super(icon); 
		decorate();
	}
	
	public CircleButton(String text, Icon icon) { 
		super(text, icon); 
		decorate();
	} 
	
	protected void decorate() { 
		setBorderPainted(false); 
		setOpaque(false); 
	}
	
	@Override 
	protected void paintComponent(Graphics g) { 
		int width = getWidth(); 
		int height = getHeight(); 
		
		Graphics2D graphics = (Graphics2D) g; 
		
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
		
		if (getModel().isArmed()) { 
			graphics.setColor(color1.darker()); 
		} else if (getModel().isRollover()) {
			graphics.setColor(color1.brighter()); 
		} else { 
			graphics.setColor(color1); 
		} 
		
		graphics.fillOval(0, 0, width, height); 
		
		FontMetrics fontMetrics = graphics.getFontMetrics(); 
		Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds(); 
		
		int textX = (width - stringBounds.width) / 2; 
		int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent(); 
		
		graphics.setColor(getForeground()); 
		graphics.setFont(getFont());
		graphics.drawString(getText(), textX, textY); 
		graphics.dispose(); 
		
		super.paintComponent(g); 
	}

}