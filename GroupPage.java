package myProj;
/**
 * this class creates the group page, using the info gathered from the group object
 * in the constructor
 */
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GroupPage extends JPanel{
	
	JLabel theMembers;
	 JLabel contentLabel;
	
	 JComboBox<String> combo1;
	 JComboBox<String> combo2;
	
	 String[] names;
	 String[] contents;
	 
	 
	 JButton visit;
	 JButton look;
	 JButton postToGroup;
	 JButton leave;
	 
	 
	
	AccountValidate validateUser = new AccountValidate();
	
	public GroupPage(Group group) {
		
		setLayout(null);
		setVisible(true);
		setSize(728,910);
		
		JLabel groupName = new JLabel(group.name);
		groupName.setBounds(20,20,150,30);
		groupName.setFont(new Font("Serif", Font.PLAIN, 25));
		add(groupName);
		
		JLabel countryName = new JLabel("Country: "+group.country);
		countryName.setBounds(20,110,200,30);
		countryName.setFont(new Font("Serif", Font.PLAIN, 18));
		add(countryName);
		
		JLabel hobbies = new JLabel("Hobbies: "+group.hobbies);
		hobbies.setBounds(20,140,600,30);
		hobbies.setFont(new Font("Serif", Font.PLAIN, 18));
		add(hobbies);
		
		
		//if we are a member of the group extra buttons are added
		if(group.getMembers().contains(ProfilePage.OurUser)) {
			
		JLabel creatorName = new JLabel("Creator: "+group.creator.getNickname());
		creatorName.setBounds(20,80,150,30);
		creatorName.setFont(new Font("Serif", Font.PLAIN, 18));
		add(creatorName);
			
		theMembers = new JLabel("Members");
		theMembers.setBounds(120, 440, 80, 20);
		theMembers.setFont(new Font("Serif", Font.PLAIN, 15));
		add(theMembers);	
		
		//group members names will be displayed in a combo box
		names = new String[group.getMembers().size()];
		for (int i=0;i<group.getMembers().size();i++) {
			names[i] = group.getMembers().get(i).getNickname();
		}
		combo1 = new JComboBox<String>(names);
		combo1.setBounds(200,440,140,25);
		add(combo1);
		
		
		contentLabel = new JLabel("Contents");
		contentLabel.setBounds(120, 480, 80, 20);
		
		//posted content names will be displayed in a combo box
		contents = new String[group.contents.size()];
		for (int i=0;i<group.contents.size();i++) {
			contents[i] = "By "+group.contents.get(i).getCreator()+" "+group.contents.get(i).getTitle();
		}
		combo2 = new JComboBox<String>(contents);
		combo2.setBounds(200,480,140,25);
		add(combo2);
		add(contentLabel);
		
		
		visit = new JButton("Visit");
		visit.setBounds(380,440,120,25);
		add(visit);
		
		//visit the group members page
		visit.addActionListener(
				
				new ActionListener() 
				{ 
					@Override
					public void actionPerformed(ActionEvent arg0) {
						JButton directToGroup = new JButton("Return");
						directToGroup.setBounds(350,190,120,30);
						
						directToGroup.addActionListener(
								
								new ActionListener() 
								{ 
									@Override
									public void actionPerformed(ActionEvent arg0) {
										GroupPage myGroupPage = new GroupPage(group);
										Homepage.main.newPage(myGroupPage);
									}
											
								} 
						);
						
						
						String nickname = (String) combo1.getSelectedItem();
						
						boolean isFriend = false;
						for(User theuser: ProfilePage.OurUser.followed) {
							if(theuser.getNickname().equals(nickname)) {
								isFriend = true;
								FriendsPage newProfile = new FriendsPage(theuser);
								newProfile.add(directToGroup);
								Homepage.main.newPage(newProfile);
								newProfile.setVisible(true);
							}
							
						}
						
						if(isFriend == false) {
							//if it is our page it should display our page, since we don't follow ourselves I needed to state it separately
							if(nickname.equals(ProfilePage.OurUser.getNickname())) {
								MyProfile newProfile = new MyProfile(ProfilePage.OurUser);
								newProfile.add(directToGroup);
								Homepage.main.newPage(newProfile);
								newProfile.setVisible(true);
							}
							else {
							for(User theuser: User.getUsers()) {
								if(theuser.getNickname().equals(nickname)) {
							Unfollowed newProfile = new Unfollowed(theuser);
							newProfile.add(directToGroup);
							Homepage.main.newPage(newProfile);
							newProfile.setVisible(true);
						}
						
							}
							}
						
			
						}	
					}
				} 
		);
		
		
		look = new JButton("Look");
		look.setBounds(380,480,120,25);
		add(look);
		//look at the content created in group
		look.addActionListener(
				
				new ActionListener() 
				{ 
					@Override
					public void actionPerformed(ActionEvent arg0) {
						String contentName = (String) combo2.getSelectedItem();
						String[] a = contentName.split(" ");
						contentName = "";
						
						for(int i = 2;i<a.length-1;i++) {
							contentName = contentName+a[i]+" ";
						}
						contentName = contentName + a[a.length-1];
						
						for(Content theContent: Content.contents) {
							if(theContent.getTitle().equals(contentName)) {
								
								ContentPage newContentPage = new ContentPage(theContent);
								newContentPage.setVisible(true);
							}
							
						}
					}	
				} 
		);
		
		postToGroup = new JButton("Post new content");
		postToGroup.setBounds(300,520,150,25);
		add(postToGroup);
		//creates a content creator to post content to group
		postToGroup.addActionListener(
				
				new ActionListener() 
				{ 
					@Override
					public void actionPerformed(ActionEvent arg0) {
						ContentCreatorGroup postToGroup = new ContentCreatorGroup(group);
						}	
					} 
		);
		
		
		leave = new JButton("Leave group");
		leave.setBounds(40,550,150,25);
		add(leave);
		//leave the group and remove group from users group list
		leave.addActionListener(
				
				new ActionListener() 
				{ 
					@Override
					public void actionPerformed(ActionEvent arg0) {
						group.getMembers().remove(ProfilePage.OurUser);
						ProfilePage.OurUser.Mygroups.remove(group);
						
						GroupPage page = new GroupPage(group);
						Homepage.main.newPage(page);
						JOptionPane.showMessageDialog(null,"Successfully leaved the group");
					}
				} 
		);
		
//if we are the creator of the group, extra buttons are added
if(group.creator.equals(ProfilePage.OurUser)) {
			
			JButton addUser = new JButton("Add User");
			addUser.setBounds(170,300,120,30);
			add(addUser);
			JTextField newUser = new JTextField(20);
			newUser.setBounds(20,300,120,30);
			add(newUser);   
				
			//add new user, add this group to that users group list, add user to this groups member list
			addUser.addActionListener(
					
					new ActionListener() 
					{ 
						@Override
						public void actionPerformed(ActionEvent arg0) {
							try {
								validateUser.validateNickname(newUser.getText());
								validateUser.validateNicknameToAdd(group,newUser.getText());
								
								for(User u:User.getUsers()) {
									if(u.getNickname().equals(newUser.getText())) {
										
										u.Mygroups.add(group);
										group.addMember(u);
										
									}
								}
								
								JOptionPane.showMessageDialog(null,"Successfully added the user");
								GroupPage neww = new GroupPage(group);
								Homepage.main.newPage(neww);
							}
							catch(InvalidAccountException e) {
								JOptionPane.showMessageDialog(null,e.getMessage());
							}
						}
					} 
			);
			
			
			
			JButton removeUser = new JButton("Remove User");
			removeUser.setBounds(170,340,120,30);
			add(removeUser);
			JTextField theUser = new JTextField(20);
			theUser.setBounds(20,340,120,30);
			add(theUser);
			
			//remove user from this groups member list, remove this group from users group list
			removeUser.addActionListener(
					
					new ActionListener() 
					{ 
						@Override
						public void actionPerformed(ActionEvent arg0) {
							
							try {
								validateUser.validateNickname(theUser.getText());
								validateUser.validateNicknameToRemove(group,theUser.getText());
								User removedUser = null;
								for(User u:User.getUsers()) {
									if(u.getNickname().equals(theUser.getText())) {
										removedUser = u;
										u.Mygroups.remove(group);
										group.removeMember(u);
										
									}
								}
								for(Content c:removedUser.contents) {
									if(group.contents.contains(c)) {
										group.contents.remove(c);
									}
								}
								JOptionPane.showMessageDialog(null,"Successfully removed the user");
								GroupPage neww = new GroupPage(group);
								Homepage.main.newPage(neww);
							}
							catch(InvalidAccountException e) {
								JOptionPane.showMessageDialog(null,e.getMessage());
							}
						}
					}
			);
			
			JButton deleteGroup = new JButton("Delete group");
			deleteGroup.setBounds(20,380,120,30);
			add(deleteGroup);
			
			//remove group from all members' group list, remove group from static all group list
			deleteGroup.addActionListener(
					
					new ActionListener() 
					{ 
						@Override
						public void actionPerformed(ActionEvent arg0) {
							
							for(User u:group.getMembers()) {
								u.Mygroups.remove(group);
								Group.allGroups.remove(group);
							}
								
							Homepage profile = new Homepage();
							Homepage.main.newPage(profile);
							JOptionPane.showMessageDialog(null,"Successfully deleted the group");
							
						}
					} 
			);
			
		 }
		
		}
		//if we are not a member of the group
		else {
			JButton join = new JButton("Join");
			join.setBounds(20,250,100,30);
			add(join);
			
			//add group to our group list, add us to this groups member list
			join.addActionListener(
					
					new ActionListener() 
					{ 
						@Override
						public void actionPerformed(ActionEvent arg0) {
							group.getMembers().add(ProfilePage.OurUser);
							ProfilePage.OurUser.Mygroups.add(group);
							
							//also update the page simultaneously to see the changes immediately
							GroupPage page = new GroupPage(group);
							Homepage.main.newPage(page);
							JOptionPane.showMessageDialog(null,"Successfully joined the group");
						
							
						}
					}
			);
			
		}
		
	}
}
