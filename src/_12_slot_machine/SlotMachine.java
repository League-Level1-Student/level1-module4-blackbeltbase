package _12_slot_machine;

import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SlotMachine {
JFrame throwMoneyAway = new JFrame();
JPanel panel = new JPanel();
JButton spin = new JButton();
	
	
	@SuppressWarnings("deprecation")
	void run() throws MalformedURLException{
		throwMoneyAway.setVisible(true);
		spin.setText("SPIN");
		
			JLabel reel = createLabelImage("cherry.image.jpg");
			reel.resize(200, 200);
			panel.add(reel); 
			JLabel reel2 = createLabelImage("lemon.jpg");
			reel2.resize(200, 200);
			panel.add(reel2); 
			JLabel reel3 = createLabelImage("orange.jpg");
			reel3.resize(200, 200);
			panel.add(reel3); 
		panel.add(spin);
		throwMoneyAway.add(panel);
		throwMoneyAway.pack();
	}
	
	private JLabel createLabelImage(String fileName) throws MalformedURLException{
        URL imageURL = getClass().getResource(fileName);
	if (imageURL == null){
		System.err.println("Could not find image " + fileName);
		return new JLabel();
	}
	Icon icon = new ImageIcon(imageURL);

	JLabel imageLabel = new JLabel(icon);
	imageLabel.resize(200, 200);
	return imageLabel;
}
//add method to make individual reels
	
}
