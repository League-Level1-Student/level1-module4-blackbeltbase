package _12_slot_machine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SlotMachine implements ActionListener {
JFrame throwMoneyAway = new JFrame();
JPanel panel = new JPanel();
JButton spin = new JButton();
int score = 0;
JLabel showScore = new JLabel();
	int reel1Num = 0;
	int reel2Num = 0;
	int reel3Num = 0;
	JLabel reel = null;
	JLabel reel2 = null;
	JLabel reel3 = null;
	void run() throws MalformedURLException {
		throwMoneyAway.setVisible(true);
		String toString = Integer.toString(score);
		showScore.setText("Wins: "+toString);
		spin.setText("SPIN");
		spin.addActionListener(this);
			 reel = createReel(1);
			panel.add(reel); 
			reel2 = createReel(2);
			panel.add(reel2); 
			reel3 = createReel(3);
			panel.add(reel3); 
			panel.add(showScore);
		panel.add(spin);
		throwMoneyAway.add(panel);
		throwMoneyAway.pack();
		checkWin();
	}
	
	private JLabel createLabelImage(String fileName) throws MalformedURLException{
        URL imageURL = getClass().getResource(fileName);
	if (imageURL == null){
		System.err.println("Could not find image " + fileName);
		return new JLabel();
	}
	Icon icon = new ImageIcon(imageURL);

	JLabel imageLabel = new JLabel(icon);
	imageLabel.setSize(100, 100);
	return imageLabel;
}

 public JLabel createReel(int whatReel) throws MalformedURLException{
		JLabel label = null;
		Random whatPic = new Random();
		int whatNum = whatPic.nextInt(3);
		if(whatReel == 1) {
			this.reel1Num = whatNum;
		}
		else if(whatReel == 2) {
			this.reel2Num = whatNum;
		}
		else if(whatReel == 3) {
			this.reel3Num = whatNum;
		}
		
		
		if(whatNum == 0) {
			label = createLabelImage("cherry.image.jpg");
		}
		else if(whatNum == 1) {
			label = createLabelImage("lemon.jpg");
		}
		else if(whatNum == 2) {
			label = createLabelImage("orange.jpg");
		}
		return label;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		throwMoneyAway.dispose();
			try {
				run();
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	
	private void checkWin() {
		if(reel1Num == reel2Num && reel2Num == reel3Num) {
			JOptionPane.showMessageDialog(null, "You Win");
			score++;
		}
		else {
			JOptionPane.showMessageDialog(null, "You lose");
		}
	}
	
}
