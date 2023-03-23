package myProj;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* We create a frame to take user info to create an account
 * 
 */
public class SignIn extends JFrame{
	
	TheMainFrame main;
	JFrame thisFrame = this;
	public SignIn()
	{
	super("Sign in now!");
	//SignIn creates a frame to enter the user info for sign in
			this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);;
			this.setLayout(null);
			JLabel label3 = new JLabel("Nickname:");
			JTextField nickname = new JTextField(20);
			label3.setBounds(10, 52, 100, 100);
			nickname.setBounds(110, 90, 130, 25);
			this.add(label3);
			this.add(nickname);
	
			JLabel label2 = new JLabel("Password:");
			JTextField password = new JTextField(20);
			label2.setBounds(10, 92, 100, 100);
			password.setBounds(110, 130, 130, 25);
			this.add(label2);
			this.add(password);
						
			JButton button = new JButton("Login");
			button.setBounds(70, 170, 120, 40);
			
			this.add(button);		
			this.setVisible(true);
			this.setSize(300, 600);
			
			
			
			button.addActionListener(
					// An anonymous inner class is declared without a name 
					// and typically appears inside a method declaration.
					new ActionListener() // anonymous inner class
					{ 
						@Override
						public void actionPerformed(ActionEvent arg0) {
							boolean in = false;
							
							for (User user:User.getUsers()) {
								if (user.getNickname().equals(nickname.getText())) {
									if(user.getPassword().equals(password.getText())) {							
										Homepage home = new Homepage();
										ProfilePage.OurUser = user;
										TheMainFrame main = new TheMainFrame();
										Homepage.main = main;
										main.add(home);
										main.setVisible(true);
										main.setSize(550,700);
										in =true;
										thisFrame.setVisible(false);
									}
								}
							}
							if (!in) {
								JOptionPane.showMessageDialog(null,"Nickname or password is not valid!");
							}
							
							// will be executed every time the button is pressed.

						}
					} // end anonymous inner class
			); }
}

