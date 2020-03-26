package _08_calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class Calculator implements ActionListener {
	  




	 JPanel panel = new JPanel();
	 JTextField number1 = new JTextField(20);
	 JTextField number2 = new JTextField(20);
	 JLabel output  = new JLabel();
	 JButton add = new JButton("add");
	 JButton sub = new JButton("sub");
	 JButton div = new JButton("div");
	 JButton mult = new JButton("mult");
	 JFrame frame = new JFrame();
		public void run() {
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 add.addActionListener(this);
		 panel.add(add);
		 panel.add(sub);
		 panel.add(div);
		 panel.add(mult);
		 panel.add(number1);
		 panel.add(number2);
		 frame.add(panel);
		 frame.pack();
		 frame.setVisible(true);
	 }
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int outputYes = 0;
			JButton buttonPressed = (JButton) e.getSource();
			int num1 = Integer.parseInt(number1.getText());
			int num2 = Integer.parseInt(number2.getText());
			if(buttonPressed == add) {
				outputYes = num1+num2;
			}
			else if(buttonPressed == sub) {
				outputYes = num1-num2;
			}
			else if(buttonPressed == mult) {
				outputYes = num1*num2;
			}
			else if(buttonPressed == div) {
				outputYes = num1/num2;
			}
			String ye =  Integer. toString(outputYes);
				output.setText(ye);
				System.out.println(ye);
				 panel.add(output);
				frame.pack();
			}
}
		

		
	

