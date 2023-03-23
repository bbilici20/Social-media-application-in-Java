package myProj;
/**
 * this class creates a profile page for our friends
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class FriendsPage extends NotUnfollowed{
	
	private JButton unfollow;	
	
	
	
	public FriendsPage(User user) {
		super(user);
		// TODO Auto-generated constructor stub
		
		
		unfollow = new JButton("Unfollow!");
		unfollow.setBounds(20,500,100,30);
		add(unfollow);
		
		//unfollow removes the user from our followed list
		unfollow.addActionListener(
				// An anonymous inner class is declared without a name 
				// and typically appears inside a method declaration.
				new ActionListener() // anonymous inner class
				{ 
					@Override
					public void actionPerformed(ActionEvent arg0) {
						if(OurUser.followed.contains(user)) {
							OurUser.unfollowUser(user);
							
							Unfollowed neww = new Unfollowed(user);
							Homepage.main.newPage(neww);
							
							}
						
			
						
						// will be executed every time the button is pressed.

					}
				} // end anonymous inner class
		); 
	}

}
