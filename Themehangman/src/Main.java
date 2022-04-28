import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Main extends JFrame {
	Container contentPane;
	JLabel imageLabel;
	ImageIcon img0;
	ImageIcon img1;
	ImageIcon img2;

	public Main() {
		setTitle("Image Change");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		img0 = new ImageIcon("src/stage/stage0.png");
		img1 = new ImageIcon("src/stage/stage1.png");

		imageLabel = new JLabel(img0);
		contentPane.add(imageLabel, BorderLayout.CENTER);
		contentPane.add(new MenuPanel(), BorderLayout.SOUTH);

		setSize(300, 400);
		setVisible(true);
	}

	class MenuPanel extends JPanel {
		public MenuPanel() {

			JButton btn1 = new JButton("bart");
			JButton btn2 = new JButton("risa");

			add(btn1);
			add(btn2);

			btn1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					imageLabel.setIcon(img0);
				}
			});

			btn2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					imageLabel.setIcon(img1);
				}
			});
		}
	}

	public static void main(String[] args) {
		new Main();
	}
}

