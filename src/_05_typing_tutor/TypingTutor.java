package _05_typing_tutor;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TypingTutor implements KeyListener {
	char currentLetter;
	JFrame frame = new JFrame();
	JLabel letter = new JLabel();
	void run() {
		frame.setTitle("Type or Die");
		currentLetter = generateRandomLetter();
		letter.setText(" "+currentLetter);
		letter.setFont(letter.getFont().deriveFont(28.0f));
		letter.setHorizontalAlignment(JLabel.CENTER);
		frame.addKeyListener(this);
		frame.add(letter);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	char generateRandomLetter() {
	    Random r = new Random();
	    return (char) (r.nextInt(26) + 'a');
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		char keyCode = (char) KeyEvent.getExtendedKeyCodeForChar(e.getKeyCode());
		System.out.println("You typed :"+keyCode);
		if(keyCode == currentLetter) {
			System.out.println("correct");
			frame.setBackground(Color.green);
		}
		else {
			System.out.println("bad");
			frame.setBackground(Color.red);
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		currentLetter = generateRandomLetter();
		letter.setText(" "+currentLetter);
		
	}
}
