package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

public class Calculator extends Thread implements ActionListener, Runnable {

	JFrame frame;
	JTextField textfield;
	JButton[]  numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[9];
	JButton addButton, subButton, mulButton, divButton;
	JButton decButton, equButton, delButton, clrButton, negButton;
	JPanel panel;
	
	Font myFont = new Font("Ink Free",Font.BOLD,30);
	
	double num1=0, num2=0, result=0;
	char operator;
	
	
	public Calculator() {
		
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,550);
		frame.setLayout(null);
		
		textfield = new JTextField();
		textfield.setBounds(50, 25, 300, 50);
		textfield.setFont(myFont);
		textfield.setEditable(false);
		
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("Del");
		clrButton = new JButton("Clr");
		negButton = new JButton("(-)");
	
		
		 functionButtons[0] = addButton;
		 functionButtons[1] = subButton;
		 functionButtons[2] = mulButton;
		 functionButtons[3] = divButton;
		 functionButtons[4] = decButton;
		 functionButtons[5] = equButton;
		 functionButtons[6] = delButton;
		 functionButtons[7] = clrButton;
		 functionButtons[8] = negButton;
		 
		 
		 for(int i=0; i<9; i++) {
			 functionButtons[i].addActionListener(this);
			 functionButtons[i].setFont(myFont);
			 functionButtons[i].setFocusable(false);
		 }
		 
		 for(int i=0; i<10; i++) {
			 numberButtons[i] = new JButton(String.valueOf(i));
			 numberButtons[i].addActionListener(this);
			 numberButtons[i].setFont(myFont);
			 numberButtons[i].setFocusable(false);
		 }
		 
		 negButton.setBounds(50,430,100,50);
		 delButton.setBounds(150,430,100,50);
		 clrButton.setBounds(250,430,100,50);
		 
		 panel = new JPanel();
		 panel.setBounds(50, 100, 300, 300);
		 panel.setLayout(new GridLayout(4,4,10,10));
		
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equButton);
		panel.add(divButton);
		
		frame.add(panel);
		frame.add(negButton); 
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(textfield);
		frame.setVisible(true);
	}
	
	public static synchronized void playSound(String soundName) {
		
		new Thread(new Runnable() {
			public void run() {
				try {
					AudioInputStream ais = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
					Clip clip = AudioSystem.getClip();
					clip.open(ais);
					clip.start();
		
				} catch(Exception e) {
					System.out.println("Error with playing sound");
					e.printStackTrace();
				}
			}
		}).start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		for(int i=0; i<10; i++) {
			if(e.getSource() == numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
				
				switch(i) {
				
					case 0:
						playSound("/home/ubuntu/Core2Web/Java/Calculator Project/Calculator/audio-numbers/0.wav");
						break;
					case 1:
						playSound("/home/ubuntu/Core2Web/Java/Calculator Project/Calculator/audio-numbers/1.wav");
						break;
					case 2:
						playSound("/home/ubuntu/Core2Web/Java/Calculator Project/Calculator/audio-numbers/2.wav");
						break;
					case 3:
						playSound("/home/ubuntu/Core2Web/Java/Calculator Project/Calculator/audio-numbers/3.wav");
						break;
					case 4:
						playSound("/home/ubuntu/Core2Web/Java/Calculator Project/Calculator/audio-numbers/4.wav");
						break;
					case 5:
						playSound("/home/ubuntu/Core2Web/Java/Calculator Project/Calculator/audio-numbers/5.wav");
						break;
					case 6:
						playSound("/home/ubuntu/Core2Web/Java/Calculator Project/Calculator/audio-numbers/6.wav");
						break;
					case 7:
						playSound("/home/ubuntu/Core2Web/Java/Calculator Project/Calculator/audio-numbers/7.wav");
						break;
					case 8:
						playSound("/home/ubuntu/Core2Web/Java/Calculator Project/Calculator/audio-numbers/8.wav");
						break;
					case 9:
						playSound("/home/ubuntu/Core2Web/Java/Calculator Project/Calculator/audio-numbers/9.wav");
						break;	
				}
			}
		}
		
		if(e.getSource() == decButton) {
			playSound("/home/ubuntu/Core2Web/Java/Calculator Project/Calculator/audio-numbers/button.wav");
			textfield.setText(textfield.getText().concat("."));
		}
		
		if(e.getSource() == addButton) {
			playSound("/home/ubuntu/Core2Web/Java/Calculator Project/Calculator/audio-numbers/button.wav");
			num1 = Double.parseDouble(textfield.getText());
			operator = '+';
			textfield.setText("");
		}
		
		if(e.getSource() == subButton) {
			playSound("/home/ubuntu/Core2Web/Java/Calculator Project/Calculator/audio-numbers/button.wav");
			num1 = Double.parseDouble(textfield.getText());
			operator = '-';
			textfield.setText("");
		}
		
		if(e.getSource() == mulButton) {
			playSound("/home/ubuntu/Core2Web/Java/Calculator Project/Calculator/audio-numbers/button.wav");
			num1 = Double.parseDouble(textfield.getText());
			operator = '*';
			textfield.setText("");
		}
		
		if(e.getSource() == divButton) {
			playSound("/home/ubuntu/Core2Web/Java/Calculator Project/Calculator/audio-numbers/button.wav");
			num1 = Double.parseDouble(textfield.getText());
			operator = '/';
			textfield.setText("");
		}
		
		if(e.getSource() == equButton) {
			playSound("/home/ubuntu/Core2Web/Java/Calculator Project/Calculator/audio-numbers/button.wav");
			num2 = Double.parseDouble(textfield.getText());
			
			switch(operator) {
			
				case '+':
					result = num1 + num2;
					break;
				
				case '-':
					result = num1 - num2;
					break;
					
				case '*':
					result = num1 * num2;
					break;
					
				case '/':
					result = num1 / num2;
					break;
				}
			
			textfield.setText(String.valueOf(result));
			num1 = result;
		}
	
		if(e.getSource() == clrButton) {
			playSound("/home/ubuntu/Core2Web/Java/Calculator Project/Calculator/audio-numbers/clear.wav");
			textfield.setText("");
		}
		

		if(e.getSource() == delButton) {
			playSound("/home/ubuntu/Core2Web/Java/Calculator Project/Calculator/audio-numbers/delete.wav");
			String str = textfield.getText();
			textfield.setText("");
			for(int i=0; i<str.length()-1; i++) {
				textfield.setText(textfield.getText()+str.charAt(i));
			}
		}
			
		if(e.getSource() == negButton) {
			playSound("/home/ubuntu/Core2Web/Java/Calculator Project/Calculator/audio-numbers/button.wav");
			double temp = Double.parseDouble(textfield.getText());
			temp *= -1;
			textfield.setText(String.valueOf(temp));
		}
	}
	
	
}