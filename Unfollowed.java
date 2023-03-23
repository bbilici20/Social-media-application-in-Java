package myProj;
/**
 * profile pages for unfollowed users have an extra join button
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Unfollowed extends ProfilePage{

	private JButton follow;	
	
	
	public Unfollowed(User user) {
		super(user);
		
		
		follow = new JButton("Follow!");
		follow.setBounds(20,500,150,30);
		add(follow);
		
		//add the user to our followed user list
		follow.addActionListener(
				
				new ActionListener()
				{ 
					@Override
					public void actionPerformed(ActionEvent arg0) {
						if(!OurUser.followed.contains(user)) {
						OurUser.followUser(user);
						//updates the unfollowed users page to show extra content
						FriendsPage neww = new FriendsPage(user);
						Homepage.main.newPage(neww);
						}
					}
				}
		); 
	}

}
