package _04_chuckle_clicker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ChuckleClicker implements ActionListener {
	JButton joke = new JButton();
	JButton punchline = new JButton();
void run(){
	createChuckles();
}
	

private JFrame createChuckles() {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	joke.setText("joke");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	punchline.setText("punchline");
	joke.addActionListener(this);
	punchline.addActionListener(this);
	frame.add(panel);
	panel.add(joke);
	panel.add(punchline);
	frame.pack();
	frame.setVisible(true);
	return null;
}


@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	JButton buttonPressed = (JButton) e.getSource();
if(buttonPressed == joke) {
	JOptionPane.showMessageDialog(null, "Why was the first car round?");
}
else if(buttonPressed == punchline) {
	JOptionPane.showMessageDialog(null, "Because people needed to get A- round!");
}
}
}
