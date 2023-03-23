package myProj;
/**
 * we can access everything from homepage
 * the static main frame is the frame where every profile and group page will be displayed
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;

public class Homepage extends JPanel{
	
	public static TheMainFrame main;
	public JButton myProfile;	 
	public JButton createContent;
	public JPanel thisPanel = this;
	public AccountValidate validateThroughNickname = new AccountValidate();
	public ContentValidate validateTheContent = new ContentValidate();
	public GroupValidate validateTheGroup = new GroupValidate();
	
	public Homepage(){
		
		this.setLayout(null);
		
		JLabel welcome = new JLabel("Welcome!");
		welcome.setBounds(80,10,300,40);
		welcome.setFont(new Font("Serif", Font.PLAIN, 25));	
		add(welcome);
		
		JLabel users;JButton Search;JTextField name;
		JLabel groups;JButton searchGroup;JTextField groupName;
		
		groupName = new JTextField(20);
		groupName.setBounds(120, 140, 130, 25);
		searchGroup = new JButton("Search");
		searchGroup.setBounds(270,140,120,25);
		
		groups = new JLabel("Group");
		groups.setBounds(80, 140, 40, 20);
		groups.setFont(new Font("Serif", Font.PLAIN, 15));
		
		add(groupName);add(searchGroup);add(groups);
		
		
		
		name = new JTextField(20);
		name.setBounds(120, 100, 130, 25);
		Search = new JButton("Search");
		Search.setBounds(270,100,120,25);
		
		users = new JLabel("User");
		users.setBounds(80, 100, 40, 20);
		users.setFont(new Font("Serif", Font.PLAIN, 15));
			
		add(name);add(Search);add(users);
		
		JLabel contents;JTextField contentName;JButton searchContent;
			
		contentName = new JTextField(20);
		contentName.setBounds(120, 180, 130, 25);
		searchContent = new JButton("Search");
		searchContent.setBounds(270,180,120,25);
		
		contents = new JLabel("Contents");
		contents.setBounds(60, 180, 65, 20);
		contents.setFont(new Font("Serif", Font.PLAIN, 15));	
		
		add(contentName);add(searchContent);add(contents);
		
		//searches content using the content name entered and creates a content page accordingly
		searchContent.addActionListener(
				 
				new ActionListener() 
				{ 
					@Override
					public void actionPerformed(ActionEvent arg0) {
						
						boolean contentExist = false;
						for(Content c:Content.contents) {
							if(c.getTitle().equals(contentName.getText())) {
								contentExist = true;
								ContentPage newContentPage = new ContentPage(c);
							}
						}
						if(!contentExist) {
							JOptionPane.showMessageDialog(null,"This content doesn't exist!");
						}
						
					}
					
				} 
		); 
			//searches for user using the nickname entered an create a profile page accordingly
			Search.addActionListener(
					
					new ActionListener()
					{ 
						@Override
						public void actionPerformed(ActionEvent arg0) {
							String nickname = name.getText();
							
							boolean isFriend = false;
							for(User theuser: ProfilePage.OurUser.followed) {
								if(theuser.getNickname().equals(nickname)) {
									isFriend = true;
									FriendsPage newProfile = new FriendsPage(theuser);
									Homepage.main.newPage(newProfile);
									newProfile.setVisible(true);
								}
								
							}	
							if(isFriend == false) {
								
								try {
									validateThroughNickname.validateNickname(nickname);
									
									User searched = null;
									for(User user:User.getUsers()) {
										if(user.getNickname().equals(name.getText())) {
										searched = user;
									}	
									}
								
									Unfollowed newProfile = new Unfollowed(searched);
									Homepage.main.newPage(newProfile);
									newProfile.setVisible(true);
								}
								catch(InvalidAccountException e) {
									JOptionPane.showMessageDialog(null,e.getMessage());
								}
								
							}
						}
					} 
			); 
			
			
			searchGroup.addActionListener(
					//searches group and creates a group page
					new ActionListener() 
					{ 
						@Override
						public void actionPerformed(ActionEvent arg0) {
							String groupsName = groupName.getText();
							
							boolean isMyGroup = false;
							for(Group theGroup: ProfilePage.OurUser.Mygroups) {
								if(theGroup.name.equals(groupsName)) {
									isMyGroup = true;
									GroupPage myGroupPage = new GroupPage(theGroup);
									Homepage.main.newPage(myGroupPage);
									
								}
								
							}	
							if(isMyGroup == false) {
								
								try {
									validateTheGroup.validateGroupName(groupName.getText());
									
									Group theGroup = null;
									for(Group group:Group.allGroups) {
										if(group.name.equals(groupName.getText())) {
											theGroup = group;
										}	
									}
								
									GroupPage myGroupPage = new GroupPage(theGroup);
									Homepage.main.newPage(myGroupPage);
									
								}
								catch(InvalidGroupException e) {
									JOptionPane.showMessageDialog(null,e.getMessage());
								}
								
							}
						}
					} 
			); 
		
		myProfile = new JButton("My profile");
		myProfile.setBounds(120,450,200,30);
		myProfile.setBackground(Color.WHITE);
		add(myProfile);
	
		createContent = new JButton("Create new Content");
		createContent.setBounds(120,350,200,30);
		createContent.setBackground(Color.WHITE);
		add(createContent);
		
		//creates a content creator page
		createContent.addActionListener(
				 
				new ActionListener() 
				{ 
					@Override
					public void actionPerformed(ActionEvent arg0) {
						
						ContentCreatorUser contentCreator = new ContentCreatorUser(ProfilePage.OurUser);
					}
					
				}
		); 
		
		//we can go to our profile page pressing this button 
		myProfile.addActionListener(
				 
				new ActionListener() 
				{ 
					@Override
					public void actionPerformed(ActionEvent arg0) {
						
						MyProfile profile = new MyProfile(ProfilePage.OurUser);
						main.newPage(profile);
						
					}
				}
		); 
		
		this.setSize(728,910);
	}
	
}
