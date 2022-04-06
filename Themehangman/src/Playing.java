import java.awt.*;
import java.awt.event.*;
import java.text.Normalizer;

import javax.swing.*;
import javax.swing.event.*;

public class Playing extends ProSetting {
	public MyPanel panel;
	
	private JButton keyboard[];
	private JButton text[];
	private JTextField input;
	
	private String que;
	private char[][] que_answer;
	 
	private char ch[] = {
			'ㄱ', 'ㄴ', 'ㄷ', 'ㄹ', 'ㅁ',
			'ㅂ', 'ㅅ', 'ㅇ', 'ㅈ', 'ㅊ',
			'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ',
			'ㅏ', 'ㅑ', 'ㅓ', 'ㅕ', 'ㅗ',
			'ㅛ', 'ㅜ', 'ㅍ', 'ㅡ', 'ㅣ'	
	};
	
	public Playing() {
	    que = "바다코끼리";
		que_answer = new char[][] {
			{'ㅂ', 'ㅏ'},
			{'ㄷ', 'ㅏ'},
			{'ㅋ', 'ㅗ'},
			{'ㄱ', 'ㄱ', 'ㅣ'},
			{'ㄹ', 'ㅣ'}
		};
		
		i = new ImageIcon("src/img/background.png");
		im = i.getImage();
		
	    panel = new MyPanel();
	    
	    // Screen
	    // replace이용해서 배열 stage 이미지 만들기 350x300px 로 만들기
		ImageIcon stage = new ImageIcon("src/stage/stage1.png");
	   
		JButton screen = new JButton(stage);
		screen.setContentAreaFilled(false);
		screen.setBorderPainted(false);
		screen.setFocusPainted(false);
		screen.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));
		
		// Question
	    JPanel question = new JPanel(new GridLayout(2, 5));
	    question.setBackground(background);
	    question.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
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
	    JPanel typing = new JPanel(new GridLayout(5, 5, 5, 5));
	    typing.setBackground(background);
	    typing.setBorder(BorderFactory.createEmptyBorder(15, 50, 10, 50));
	    keyboard = new JButton[ch.length];
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
				System.out.println("텍스트 입력 : " + input.getText() + ", " + que);
				if(input.getText().equals(que)) {
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
				System.out.println(keyboard[idx].getText() + "키 입력!");
				answer(idx);
			}
		});
	}
	
	private void answer(int idx) {
		for(int i=0; i<que_answer.length; i++) {
			for(int j=0; j<que_answer[i].length; j++) {
				if(ch[idx] == que_answer[i][j]) {
					if(text[i].getText() == " ") {
						text[i].setText(String.valueOf(que_answer[i][j]));
						que_answer[i][j] = '/';
					} else if(text[i].getText().charAt(0) > que_answer[i][j]) {
						String temp = String.valueOf(que_answer[i][j]);
						temp +=	text[i].getText();
						text[i].setText(temp);
						que_answer[i][j] = '/';
					} else {
						text[i].setText(text[i].getText() + String.valueOf(que_answer[i][j]));
						que_answer[i][j] = '/';
					}
				}
			}
		}
	}
	
	public void reLoad() {
		// 데이터 불러오기
	    que = "바다코끼리";
		que_answer = new char[][] {
			{'ㅂ', 'ㅏ'},
			{'ㄷ', 'ㅏ'},
			{'ㅋ', 'ㅗ'},
			{'ㄱ', 'ㄱ', 'ㅣ'},
			{'ㄹ', 'ㅣ'}
		};
		
		input.setText("정답입력");
	}
	public void setVisible(boolean tf) {
		panel.setVisible(tf);
	}
	
		
}