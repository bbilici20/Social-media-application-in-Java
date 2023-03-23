package myProj;
/**
 * main frame is created to display several pages
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TheMainFrame extends JFrame {
	
	public JButton home;
	public TheMainFrame thisFrame = this;
	public JPanel currentPanel;
	
	public TheMainFrame() {
		
		home = new JButton("Homepage");
		home.setBounds(350,20,120,30);
		//home button sends us to home page every time we press it
		home.addActionListener(
				 
				new ActionListener()
				{ 
					@Override
					public void actionPerformed(ActionEvent arg0) {
						
						if(ProfilePage.OurUser != null) {
							Homepage newHome = new Homepage();
							//down casting: homepage is a jframe
							thisFrame.newPage(newHome);
							
						}
						}
				} 
		); 
	}
	
	//this method erases everything on the frame and uploads the next page
	public void newPage(JPanel b) {
			this.getContentPane().removeAll();
			this.repaint();
			this.add(b);
			//home page button is on every page, for flexibility
			b.add(home);
			
			
	}
}
