package myProj;
/**
 * group creator is a frame for creating a group. the obtained info is used to create a group
 */
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class GroupCreator extends JFrame{
	JLabel title;
	JLabel name;
	JLabel memberName;
	JTextField writeMembers;
	JTextField groupName;
	JButton createTheGroup;
	GroupValidate validateTheGroup = new GroupValidate();
	JLabel hobbies;
	JTextField writeHobbies;
	JLabel country;
	JTextField writeCountry;
	
	public GroupCreator() {
		setLayout(null);
		title = new JLabel("Create new group");
		title.setFont(new Font("Serif", Font.BOLD, 20));
		title.setBounds(10,20,300,25);
		add(title);
		
		name = new JLabel("Group name");
		name.setBounds(10,60,120,20);
		groupName = new JTextField(20);
		groupName.setBounds(150,60,250,20);
		add(name);
		add(groupName);
		
		memberName = new JLabel("Members");
		memberName.setBounds(10,90,120,20);
		writeMembers = new JTextField("Write group members' nicknames here.Leave a space between each username.");
		writeMembers.setBounds(150,90,400,25);
		add(memberName);
		add(writeMembers);
		
		
		hobbies = new JLabel("Hobbies");
		hobbies.setBounds(10,120,120,20);
		writeHobbies = new JTextField("Write hobbies here.");
		writeHobbies.setBounds(150,120,400,25);
		add(hobbies);
		add(writeHobbies);
		
		country = new JLabel("Country");
		country.setBounds(10,150,120,20);
		writeCountry = new JTextField();
		writeCountry.setBounds(150,150,120,25);
		add(country);
		add(writeCountry);
		
		createTheGroup = new JButton("Create group");
		createTheGroup.setBounds(100,400,120,30);
		add(createTheGroup);
		
		//create the group and add it to all groups and to the members of the group
		createTheGroup.addActionListener(
				
				new ActionListener() 
				{ 
					@Override
					public void actionPerformed(ActionEvent arg0) {
						
						try {
							String[] nameList = writeMembers.getText().split(" ");
							validateTheGroup.validateCreatedGroup(groupName.getText(),nameList);
							ArrayList<User> newMembers = new ArrayList<User>();
							for(String name:nameList) {
								for(User u:User.getUsers()) {
									if(u.getNickname().equals(name)) {
										newMembers.add(u);

									}
								}
							}
							newMembers.add(ProfilePage.OurUser);
							Group newGroup = new Group(ProfilePage.OurUser,newMembers,groupName.getText(),writeHobbies.getText(),writeCountry.getText());
							
							setVisible(false);
							MyProfile neww = new MyProfile(ProfilePage.OurUser);
							Homepage.main.newPage(neww);
							JOptionPane.showMessageDialog(null,"Group "+groupName.getText()+" is created!");
							
							
						}
						catch(InvalidGroupException e) {
							JOptionPane.showMessageDialog(null,e.getMessage());
						}
					
					}
				} 
		);
		
		setVisible(true);
		setSize(750,900);
		
		
	}
}
