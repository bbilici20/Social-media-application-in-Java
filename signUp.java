package myProj;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * create a new account
 * @author beril
 *
 */

public class signUp extends JFrame{
	
	JButton selectButton;  
    JFileChooser fc;
    File file = null;
    JLabel label7;
    JLabel name1;
    JLabel surname1;
    JLabel password1;
    JLabel nickname1;
    JLabel email1;
    JFrame thisFrame = this;
    
	public signUp()
	{
		super("Sign up now!");
		//signUp creates a panel to enter the user info
				this.setLayout(null);
				name1 = new JLabel("Enter name:");
				JTextField name = new JTextField(20);
				name1.setBounds(10, 12, 100, 100);
				name.setBounds(110, 50, 130, 25);
				this.add(name1);
				this.add(name);
				

				surname1 = new JLabel("Enter surname:");		
				JTextField surname = new JTextField(20);
				surname1.setBounds(10, 42, 100, 100);
				surname.setBounds(110, 80, 130, 25);
				this.add(surname1);
				this.add(surname);
				
				password1 = new JLabel("Enter password:");
				JTextField password = new JTextField(20);
				password1.setBounds(10, 72, 100, 100);
				password.setBounds(110, 110, 130, 25);
				this.add(password1);
				this.add(password);
				
				nickname1 = new JLabel("Enter nickname:");
				JTextField nickname = new JTextField(20);
				nickname1.setBounds(10, 102, 100, 100);
				nickname.setBounds(110, 140, 130, 25);
				this.add(nickname1);
				this.add(nickname);
				
				email1 = new JLabel("Enter email:");
				JTextField email = new JTextField(20);
				email1.setBounds(10, 132, 100, 100);
				email.setBounds(110, 170, 130, 25);
				this.add(email1);
				this.add(email);
				
				JLabel label5 = new JLabel("Enter age:");
				JTextField age = new JTextField(20);
				label5.setBounds(10, 162, 100, 100);
				age.setBounds(110, 200, 130, 25);
				this.add(label5);
				this.add(age);
				
				JButton chooseFile = new JButton("Choose profile photo (optional)");
				chooseFile.setBounds(10, 250, 250, 20);
				
		        //Create a file chooser
		        fc = new JFileChooser();
		        this.add(chooseFile);
				this.setVisible(true);
				this.setSize(300, 600);
				
				chooseFile.addActionListener(
						
						new ActionListener() 
						{ 
							@Override
							public void actionPerformed(ActionEvent arg0) {					
						            int returnVal = fc.showOpenDialog(null);

						            if (returnVal == JFileChooser.APPROVE_OPTION) {
						                file = fc.getSelectedFile();
						                
										JTextField image = new JTextField("Selected file: "+file.getPath());
						                image.setBounds(10,268,250,20);
										add(image);
						            }						
							}
						} 
							
				); 
				
				//create new account and add it to the static users user list
				JButton button = new JButton("Sign up now!");
				button.setBounds(70, 300, 120, 40);
				this.add(button);
				button.addActionListener(
						
						new ActionListener() 
						{ 
							@Override
							public void actionPerformed(ActionEvent arg0) {
							
								
								try{
									User newUser = new User(name.getText(), surname.getText(), nickname.getText(), age.getText(), 
											email.getText(), password.getText());
									//if file chosen, pro photo is set, otherwise default will be set
									if(file != null) {
									newUser.setProfilePhoto(file.getPath());
									
									}
									else {
									newUser.setProfilePhoto("C:\\Users\\beril\\Downloads\\defaultProfile.jfif");
									
									}
									
									AccountValidate validate = new AccountValidate();
									validate.validateUser(newUser);
									User.getUsers().add(newUser);
									
									Homepage home = new Homepage();
									ProfilePage.OurUser = newUser;
									TheMainFrame main = new TheMainFrame();
									Homepage.main = main;
									main.add(home);
									main.setVisible(true);
									main.setSize(550,700);
									thisFrame.setVisible(false);
								}
								catch(InvalidAccountException e)
								{
									JOptionPane.showMessageDialog(null,e.getMessage());
								}
							}
						}
				); 
	}
}
