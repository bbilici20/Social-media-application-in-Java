package myProj;
/**
 * this class creates a edit page to edit account, the entered informations are used in set functions 
 * to update account
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EditAccount extends JFrame {
	JButton selectButton;
    JFileChooser fc;
    File file = null;
    JLabel label7;
    JLabel name1;
    JLabel surname1;
    JLabel password1;
    JLabel nickname1;
    JLabel email1;
    JLabel age1;
    String myPhoto = ProfilePage.OurUser.getProfilePhoto();
    AccountValidate forEdit = new AccountValidate();

	public EditAccount(User user) {
		super("Edit your account");
	//signUp creates a panel to enter the user info
			this.setLayout(null);
			name1 = new JLabel("Enter name:");
			JTextField name = new JTextField(user.getName());
			name1.setBounds(10, 12, 100, 100);
			name.setBounds(110, 50, 130, 25);
			this.add(name1);
			this.add(name);
			

			surname1 = new JLabel("Enter surname:");		
			JTextField surname = new JTextField(user.getSurname());
			surname1.setBounds(10, 42, 100, 100);
			surname.setBounds(110, 80, 130, 25);
			this.add(surname1);
			this.add(surname);
			
			password1 = new JLabel("Enter password:");
			JTextField password = new JTextField(user.getPassword());
			password1.setBounds(10, 72, 100, 100);
			password.setBounds(110, 110, 130, 25);
			this.add(password1);
			this.add(password);
			
			email1 = new JLabel("Enter email:");
			JTextField email = new JTextField(user.getEmail());
			email1.setBounds(10, 102, 100, 100);
			email.setBounds(110, 140, 130, 25);
			this.add(email1);
			this.add(email);
			
			age1 = new JLabel("Enter age:");
			JTextField age = new JTextField(user.getAge());
			age1.setBounds(10, 132, 100, 100);
			age.setBounds(110, 170, 130, 25);
			this.add(age1);
			this.add(age);
			
			
			
			JButton chooseFile = new JButton("Choose profile photo (optional)");
			chooseFile.setBounds(10, 250, 250, 20);
			
			JButton removePhoto = new JButton("Remove your profile photo");
			removePhoto.setBounds(10, 290, 250, 20);
			
	        //Create a file chooser
	        fc = new JFileChooser();
	        
	        
			JButton editNow = new JButton("Edit account now");
			editNow.setBounds(70, 340, 120, 40);
			
			add(editNow);
			add(chooseFile);
			add(removePhoto);
			setVisible(true);
			setSize(300, 600);
			
			chooseFile.addActionListener(
					// An anonymous inner class is declared without a name 
					// and typically appears inside a method declaration.
					new ActionListener() // anonymous inner class
					{ 
						@Override
						public void actionPerformed(ActionEvent arg0) {					
					            int returnVal = fc.showOpenDialog(null);

					            if (returnVal == JFileChooser.APPROVE_OPTION) {
					                file = fc.getSelectedFile();
					                myPhoto = file.getPath();
					                
					            }						
						}
					} // end anonymous inner class
						
			); 
			
			//removePhoteo sets the profile photo to default photo
			removePhoto.addActionListener(
					// An anonymous inner class is declared without a name 
					// and typically appears inside a method declaration.
					new ActionListener() // anonymous inner class
					{ 
						@Override
						public void actionPerformed(ActionEvent arg0) {					
					           myPhoto = "C:\\Users\\beril\\Downloads\\defaultProfile.jfif"; 	
					           JOptionPane.showMessageDialog(null,"Profile photo removed");
						}
					} // end anonymous inner class
						
			); 
			
			//edit everything except nickname
			editNow.addActionListener(
					// An anonymous inner class is declared without a name 
					// and typically appears inside a method declaration.
					new ActionListener() // anonymous inner class
					{ 
						@Override
						public void actionPerformed(ActionEvent arg0) {	
							
							try {
							   forEdit.validateEditPassword(password.getText());
					           user.setName(name.getText());
					           user.setSurname(surname.getText());
					           user.setEmail(email.getText());
					           user.setAge(age.getText());
					           user.setPassword(password.getText());
					           user.setProfilePhoto(myPhoto);
					           MyProfile neww = new MyProfile(ProfilePage.OurUser);
							   Homepage.main.newPage(neww);
							   JOptionPane.showMessageDialog(null,"Successfully edited account");
							   setVisible(false);
							}
							catch(InvalidAccountException e) {
								JOptionPane.showMessageDialog(null,e.getMessage());
							}
						}
					} // end anonymous inner class
						
			); 
}
}
