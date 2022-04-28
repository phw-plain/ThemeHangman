import java.awt.*;
import java.awt.event.*;
import java.text.Normalizer;

import javax.swing.*;
import javax.swing.event.*;

public class Playing extends ProSetting {
	public MyPanel panel;
	
	private CircleButton keyboard[];
	private JButton text[];
	private JTextField input;
	
	private int que_cnt;
	private String que;
	private char[] que_answer;
	
	private JLabel screen;
	private ImageIcon[] icon = new ImageIcon[10];
	
	private char ch[] = {
			'A', 'B', 'C', 'D', 'E',
			'F', 'G', 'H', 'I', 'J',
			'K', 'L', 'M', 'N', 'O', 
			'P', 'Q', 'R', 'S', 'T', 
			'U', 'V', 'W', 'X', 'y',
			'Z'
	};
	
	public Playing() {
		que_cnt = 0;
	    que = "MOVIE";
		que_answer = new char[] {
			'M', 'O', 'V', 'I', 'E'
		};
	    
		i = new ImageIcon("src/img/background.png");
		im = i.getImage();
		
	    panel = new MyPanel();
	   
	    String url = "src/stage/stage0.png";
	    for(int i=0; i<5; i++) {
	    	icon[i] = new ImageIcon(url);
		    System.out.println(url);
		    url = url.replace(Integer.toString(i), Integer.toString(i+1));
	    }
	    
	    // Screen
		screen = new JLabel(icon[0]);
		screen.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));
		
		// Question
	    JPanel question = new JPanel(new GridLayout(2, 5));
	    question.setBackground(background);
	    question.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
	    text = new JButton[10];
	    for(int i=0; i<que.length(); i++) {
	    	text[i] = new JButton();
	    	text[i].setText(" ");
	    	text[i].setFont(font1);
	    	text[i].setContentAreaFilled(false);
	    	text[i].setBorderPainted(false);
	    	text[i].setFocusPainted(false);
	    	question.add(text[i]);
	    }
	    for(int i=que.length(); i<que.length()*2; i++) {
	    	text[i] = new JButton();
	    	text[i].setText("─");
	    	text[i].setFont(font1);
	    	text[i].setContentAreaFilled(false);
	    	text[i].setBorderPainted(false);
	    	text[i].setFocusPainted(false);
	    	question.add(text[i]);
	    }
	    
	    // Typing
	    JPanel typing = new JPanel(new GridLayout(6, 5, 5, 5));
	    typing.setBackground(background);
	    typing.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50));
	    keyboard = new CircleButton[ch.length];
	    for(int i=0; i<ch.length; i++) {
	    	keyboard[i] = new CircleButton(String.valueOf(ch[i]));
	    	keyboard[i].setFont(font1);
	    	keyboard[i].setContentAreaFilled(true);
	    	keyboard[i].setBorderPainted(true);
	    	keyboard[i].setFocusPainted(false);
	    	keyboard[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		    typing.add(keyboard[i]);
	    }
	    for(int i=0; i<ch.length; i++) {
	    	keyevent(i);
	    }
	    
	    // Answer
	    JPanel answer = new JPanel();
	    answer.setBackground(background);
	    answer.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
	    input = new JTextField("정답입력", 10);
	    input.setFont(font1);
	    
	    input.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((input.getText().toUpperCase()).equals(que)) {
					JOptionPane.showMessageDialog(null
							, "정답!!"
							, "ThemeHangman"
							, JOptionPane.PLAIN_MESSAGE
					);
					panel.setVisible(false);
				}
			}
		});
	    
	    answer.add(input);

	    panel.add(screen);
	    panel.add(question);
	    panel.add(typing);
	    panel.add(answer);
	}

	private void keyevent(int idx) {
		keyboard[idx].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 버튼 클릭 효과음 추가하기
				answer(idx);
				que_cnt++;
				changeIcon();
		    	keyboard[idx].setEnabled(false);
			}
		});
	}
	
	private void changeIcon() {
		screen.setIcon(icon[que_cnt]);
	}
	
	private void answer(int idx) {
		for(int i=0; i<que_answer.length; i++) {
			if(ch[idx] == que_answer[i]) {
				if(text[i].getText() == " ") {
					text[i].setText(String.valueOf(que_answer[i]));
					que_answer[i] = '/';
				} else if(text[i].getText().charAt(0) > que_answer[i]) {
					String temp = String.valueOf(que_answer[i]);
					temp +=	text[i].getText();
					text[i].setText(temp);
					que_answer[i] = '/';
				} else {
					text[i].setText(text[i].getText() + String.valueOf(que_answer[i]));
					que_answer[i] = '/';
				}
			}
		}
	}
	
	public void reLoad(int idx) {
		// idx 테마의
		// 데이터 불러오기
		que_cnt = 0;
	    que = "MOVIE";
		que_answer = new char[] {
			'M', 'O', 'V', 'I', 'E'
		};
		screen.setIcon(icon[0]);
		
	    for(int i=0; i<text.length/2; i++) {
	    	text[i].setText(" ");
	    }
	    
	    for(int i=0; i<keyboard.length; i++) 
	    	keyboard[i].setEnabled(true);
	    
		input.setText("정답입력");
	}
	
	public void setVisible(boolean tf) {
		panel.setVisible(tf);
	}
	
		
}