package myProj;
/**
 * this is our profile
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class MyProfile extends NotUnfollowed{
	
	public MyProfile(User user) {
		super(user);
		
		
		JButton Premium;
		JButton CreateGroup;
		JButton signout;
		JButton deleteAccount;
		JButton editAccount;
		
		signout = new JButton("Sign out");
		signout.setBounds(250,600,100,30);
		
		editAccount = new JButton("Edit account");
		editAccount.setBounds(120,600,110,30);
		
		deleteAccount = new JButton("Delete account");
		deleteAccount.setBounds(380,600,120,30);
		
		add(signout);
		add(deleteAccount);
		add(editAccount);
		
		//if we are premium we can quit
		if(User.premiums.contains(OurUser)) {
			Premium = new JButton("Quit premium");
			Premium.setBounds(350,70,120,30);
			add(Premium);
			
			CreateGroup = new JButton("Create a group");
			CreateGroup.setBounds(350,150,120,30);
			add(CreateGroup);
			
			//remove our user from premiums
			Premium.addActionListener(
					new ActionListener()
					{ 
						@Override
						public void actionPerformed(ActionEvent arg0) {
							 User.premiums.remove(OurUser);
				}
					} 
			); 
			
			//creates a group creator page for premium user
			CreateGroup.addActionListener(
					new ActionListener() 
					{ 
						@Override
						public void actionPerformed(ActionEvent arg0) {
							 GroupCreator newCreatorPage = new GroupCreator();
				}
					}
			);
			
		}
		
		else {
			//if we a are not premium we can become one.
			Premium = new JButton("Be premium");
			Premium.setBounds(350,70,120,30);
			add(Premium);
			//add user to premium
			Premium.addActionListener(
					
					new ActionListener()
					{ 
						@Override
						public void actionPerformed(ActionEvent arg0) {
							User.premiums.add(OurUser);
							//updates profile page immediately to show we became premium
							MyProfile neww = new MyProfile(ProfilePage.OurUser);
							Homepage.main.newPage(neww);
							JOptionPane.showMessageDialog(null,"Become premium successfull");
						}
					} 
			); 
			
		}
			/**
			 * removes user from static users list, removes from the groups they are in, 
			 * removes from the other users followed user list, 
			 * contents of the deleted user remain still
			 */
			deleteAccount.addActionListener(
					
					new ActionListener() 
					{ 
						@Override
						public void actionPerformed(ActionEvent arg0) {
							 User.getUsers().remove(user);
							 for(User u:User.getUsers()) {
								 if(u.followed.contains(user)) {
									 u.followed.remove(user);
								 }
							 }
							 
							 for(Group g:Group.allGroups) {
								 if(g.getMembers().contains(user)) {
									 g.getMembers().remove(user);
								 }
							 }
							 Homepage.main.setVisible(false);
							 JOptionPane.showMessageDialog(null,"Deleted account successfull");
				}
					} 
			); 
			
			//closes the current main frame, you have to sign in again
			signout.addActionListener(
					
					new ActionListener() 
					{ 
						@Override
						public void actionPerformed(ActionEvent arg0) {
							 Homepage.main.setVisible(false);
							 JOptionPane.showMessageDialog(null,"Successfully signed out");
							}
					} 
			); 
			
			//creates an account editor page
			editAccount.addActionListener(
					
					new ActionListener()
					{ 
						@Override
						public void actionPerformed(ActionEvent arg0) {
							 EditAccount editA = new EditAccount(user);
						}
					} 
			); 
			}

}
