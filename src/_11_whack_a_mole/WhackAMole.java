package _11_whack_a_mole;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JButton;
public class WhackAMole implements ActionListener {

	JFrame moleFrame = new JFrame();
	JPanel feild;
	int molesWhacked = 0;
	int molesMissed = 0;
	JButton moleButton;
	Date timeStarted;
	void run() {
		feild = new JPanel();
		timeStarted = new Date();
		moleFrame.setSize(300, 300);

		int moleFound = getRandomMoleButton();
		System.out.println(moleFound);
		for(int i = 0; i<24; i++) {
			JButton button = createButton(i);
			feild.add(button); 
			if(i == moleFound) {
				moleButton = button;
				button.setText("mole!");
			}
		}
		moleFrame.add(feild);
		
		moleFrame.setVisible(true);
	}
	
	private int getRandomMoleButton() {
		Random rando = new Random();
		int thatMole = rando.nextInt(24);
		return thatMole;
	}
private JButton createButton(int buttonNumber) {
		
JButton button = new JButton();
String buttonNum = Integer.toString(buttonNumber);
button.addActionListener(this);
button.setName(buttonNum);
	button.setText(" ");
return button;
	}

void speak(String words) { 
//    try { 
//        Runtime.getRuntime().exec("say " + words).waitFor();
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
	System.out.println(words);
}


@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	System.out.println("clicked");
	JButton buttonPressed = (JButton) e.getSource();
	if(buttonPressed == moleButton ) {
		speak("gottem");
		molesWhacked++;
		
		if(molesWhacked == 10) {
			endGame( timeStarted, molesWhacked);
		}

	}
	else {
		molesMissed++;
		if(molesMissed == 1) {
			speak("darn it");
		}
		else if(molesMissed == 2) {
			speak("oof");
		}
		else if(molesMissed == 3) {
			speak("almost got him");
		}
		else if(molesMissed == 4) {
			speak("the moles will take over");
		}else if(molesMissed == 5) {
			speak("Sorry end game");
			endGame(timeStarted, molesWhacked);
		}
	
	}
	moleFrame.dispose();
	run();
}
private void endGame(Date timeAtStart, int molesWhacked) { 
    Date timeAtEnd = new Date();
    JOptionPane.showMessageDialog(null, "Your whack rate is "
            + ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / molesWhacked)
                  + " moles per second.");
    System.exit(0);
}
}
