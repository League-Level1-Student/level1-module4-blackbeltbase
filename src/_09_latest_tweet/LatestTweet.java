package _09_latest_tweet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class LatestTweet implements ActionListener {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	 JTextField userWants = new JTextField(20);
	 JButton searchTwitter = new JButton();
	 JLabel label = new JLabel();
	void run() {
		frame.setTitle("Amazing tweet finder");
		searchTwitter.setText("Search the Twitterverse");
		JOptionPane.showMessageDialog(null, "Type what you want to search for on Twitter in the textbox");
		searchTwitter.addActionListener(this);
		panel.add(searchTwitter);
		panel.add(userWants);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	private String getLatestTweet(String searchingFor) {

	    Twitter twitter = new TwitterFactory().getInstance();

	    AccessToken accessToken = new AccessToken(
	        "2453751158-IVD2VGZsvwZiRKxNe3Gs2lMjg30nvSkV1xSuPFf",
	        "vBa5PjKfuMTK1LLBG51nCUI9r5d6Ph5cAHrS73spg6Nvu");
	    twitter.setOAuthConsumer("YqeZdD2hYxOKv4QOkmp0i2djN",
	        "6XUB1r8KXBvd8Pk9HHW3NgphMxHvHWBLAr5TihnckMU0ttyGST");
	    twitter.setOAuthAccessToken(accessToken);

	Query query = new Query(searchingFor);
	    try {
	        QueryResult result = twitter.search(query);
	        return result.getTweets().get(0).getText();
	    } catch (Exception e) {
	        System.err.print(e.getMessage());
	        return "What the heck is that?";
	    }
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Tweet Tweet");
		String userWantsWhat = userWants.getText();
		String gotIt = getLatestTweet(userWantsWhat);
		System.out.println(gotIt);
		label.setText("The latest tweet on that matter was: "+ gotIt);
		panel.add(label);
		frame.pack();
	}
}
