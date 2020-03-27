package _11_whack_a_mole;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.util.Random;

import javax.swing.JButton;
public class WhackAMole {

	JFrame moleFrame = new JFrame();
	JPanel feild = new JPanel();
	
	
	
	void run() {
		moleFrame.setSize(100, 200);
		for(int i = 0; i<24; i++) {
			feild.add(createButton(i)); 
		}
		moleFrame.add(feild);
		getRandomMoleButton();
		moleFrame.setVisible(true);
	}
	
	private int getRandomMoleButton() {
		Random rando = new Random();
		int thatMole = rando.nextInt(25);
		return thatMole;
	}
private JButton createButton(int buttonNumber) {
		
		// Create a new JButton
JButton button = new JButton();
		// Set the text of the button to the dollarAmount
String buttonNum = Integer.toString(buttonNumber);
		// Increment the buttonCount (this should make the layout vertical)
button.setName(buttonNum);
		// Return your new button instead of the temporary button
return button;
		//return new JButton(button);
	}
}
