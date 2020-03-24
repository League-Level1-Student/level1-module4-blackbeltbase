package _01_nasty_surprise;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class NastySurprise implements ActionListener {
JFrame trickyFrame = new JFrame();
JButton trick = new JButton("trick");
JButton treat = new JButton ("treat");
JPanel panel = new JPanel();

public void run() {
	trick.addActionListener(this);
	treat.addActionListener(this);
	panel.add(treat);
	panel.add(trick);
	trickyFrame.add(panel);
	trickyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	trickyFrame.pack();
	trickyFrame.setVisible(true);

}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	JButton buttonPressed = (JButton) e.getSource();
	if(buttonPressed == trick) {
		showPictureFromTheInternet("https://i.redd.it/mfd1xe6l2ba31.jpg");
	}
	else if(buttonPressed == treat) {
		showPictureFromTheInternet("https://cdn.vox-cdn.com/thumbor/bAURr1Te5TEkeZnQl6TrJJItOlg=/1400x1400/filters:format(png)/cdn.vox-cdn.com/uploads/chorus_asset/file/15148206/Screen_Shot_2019_03_03_at_12.59.20_PM.png");
	}
}
private void showPictureFromTheInternet(String imageUrl) {
    try {
        URL url = new URL(imageUrl);
        Icon icon = new ImageIcon(url);
        JLabel imageLabel = new JLabel(icon);
        JFrame frame = new JFrame();
        frame.add(imageLabel);
        frame.setVisible(true);
        frame.pack();
    } catch (MalformedURLException e) {
        e.printStackTrace();
    }
}
}
