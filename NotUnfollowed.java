package myProj;
/**
 * not unfollowed creates profile pages for us or our friends
 * we can see the contents, friends and groups
 */
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class NotUnfollowed extends ProfilePage {

	 JLabel friends;
	 JLabel contentLabel;
	 JLabel groupLabel;
	 JComboBox<String> combo1;
	 JComboBox<String> combo2;
	 JComboBox<String> combo3;
	 String[] names;
	 String[] contents;
	 String[] groups;
	 
	 JButton visit;
	 JButton look;
	 JButton goSee;
	
	public NotUnfollowed(User user) {
		super(user);
		
		
		friends = new JLabel("Friends");
		friends.setBounds(160, 440, 80, 20);
		friends.setFont(new Font("Serif", Font.PLAIN, 15));
		add(friends);
		//creating a combobox to display friends of the user, create an array of string names, adding the 
		//names of the users in followed arraylist of the chosen user
		names = new String[user.followed.size()];
		for (int i=0;i<user.followed.size();i++) {
			if(User.getUsers().contains(user.followed.get(i))){
			names[i] = user.followed.get(i).getNickname();
			}
			
		}
		combo1 = new JComboBox<String>(names);
		combo1.setBounds(220,440,120,25);
		add(combo1);
		
		
		contentLabel = new JLabel("Contents");
		contentLabel.setBounds(160, 480, 80, 20);
		contents = new String[user.contents.size()];
		for (int i=0;i<user.contents.size();i++) {
			contents[i] = user.contents.get(i).getTitle();
		}
		combo2 = new JComboBox<String>(contents);
		combo2.setBounds(220,480,120,25);
		add(combo2);
		add(contentLabel);
		
		groupLabel = new JLabel("Groups");
		groupLabel.setBounds(160, 520, 80, 20);
		add(groupLabel);
		groups = new String[user.Mygroups.size()];
		for (int i=0;i<user.Mygroups.size();i++) {
			groups[i] = user.Mygroups.get(i).name;
		}
		combo3 = new JComboBox<String>(groups);
		combo3.setBounds(220,520,120,25);
		add(combo3);
		
		
		visit = new JButton("Visit");
		visit.setBounds(380,440,120,25);
		add(visit);
		//visit the chosen user
		visit.addActionListener(
				
				new ActionListener() 
				{ 
					@Override
					public void actionPerformed(ActionEvent arg0) {
						String nickname = (String) combo1.getSelectedItem();
						
						boolean isFriend = false;
						for(User theuser: OurUser.followed) {
							if(theuser.getNickname().equals(nickname)) {
								isFriend = true;
								FriendsPage newProfile = new FriendsPage(theuser);
								Homepage.main.newPage(newProfile);
								newProfile.setVisible(true);
							}
							
						}	
						if(isFriend == false) {
							for(User theuser: user.followed) {
								if(theuser.getNickname().equals(nickname)) {
									Unfollowed newProfile = new Unfollowed(theuser);
									Homepage.main.newPage(newProfile);
									newProfile.setVisible(true);
								}
						
							}
						}	
					}
				}
		);
		
		look = new JButton("Look");
		look.setBounds(380,480,120,25);
		add(look);
		//create a new content page
		look.addActionListener(
				
				new ActionListener() 
				{ 
					@Override
					public void actionPerformed(ActionEvent arg0) {
						String nickname = (String) combo2.getSelectedItem();
						for(Content theContent: user.contents) {
							if(theContent.getTitle().equals(nickname)) {
								
								ContentPage newContentPage = new ContentPage(theContent);
								newContentPage.setVisible(true);
							}
							
						}
					}	
					}
		);
		
		goSee = new JButton("Go");
		goSee.setBounds(380,520,120,25);
		add(goSee);
		//creates a group page for the chosen group
		goSee.addActionListener(
				
				new ActionListener()
				{ 
					@Override
					public void actionPerformed(ActionEvent arg0) {
						String groupsName = (String) combo3.getSelectedItem();
						
						
						for(Group theGroup: Group.allGroups) {
							if(theGroup.name.equals(groupsName)) {
								
								GroupPage myGroupPage = new GroupPage(theGroup);
								Homepage.main.newPage(myGroupPage);
								
							}
							
						}	
					}
				}
		);
		
		
	}
}
