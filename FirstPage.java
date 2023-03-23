package myProj;
/**
 * first page is where we sign in or sign up. two buttons.
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class FirstPage extends JFrame {

	private JTextArea textArea;
	private JButton button;	
	private JButton button2;
	public JLabel background;
	
	// constructor sets up Graphical User Interface
	public FirstPage() {
		
		super("Welcome to the social media app!");
				
		
		this.setLayout(null); // Layout: specifies how components are arranged.

		background=new JLabel(new ImageIcon("C:\\Users\\beril\\Downloads\\Ekran Görüntüsü (227).png"));
		background.setBounds(-20,-60,728,910);
		background.setSize(580,800);
		JLabel header = new JLabel("<html>Welcome to<br/>   CONNECT!</html>");
		
		header.setBounds(185, 50, 500, 300);
		header.setBackground(Color.PINK);
		header.setForeground(Color.WHITE);
		header.setFont(new Font("Serif", Font.BOLD, 40));
		
		button = new JButton("Sign up!");
		button.setBounds(125,450,150,30);
		button.setBackground(Color.WHITE);

		button2 = new JButton("Sign in!");
		button2.setBounds(305,450,150,30);
		button2.setBackground(Color.WHITE);
		
		//new sign up page is created
		button.addActionListener(
				// An anonymous inner class is declared without a name 
				// and typically appears inside a method declaration.
				new ActionListener() // anonymous inner class
				{ 
					@Override
					public void actionPerformed(ActionEvent arg0) {
						signUp neww = new signUp();
						neww.setVisible(true);
						
			
						
						// will be executed every time the button is pressed.

					}
				} // end anonymous inner class
		); // end call to addActionListener
	
		
		//new sign in page
 		button2.addActionListener(
 
				new ActionListener() // anonymous inner class
				{ 
					@Override
					public void actionPerformed(ActionEvent arg0) {
						SignIn neww = new SignIn();
						// will be executed every time the button is pressed.

					}
				} // end anonymous inner class
		); // end call to addActionListener

 		add(background);
 		background.add(header);
 		background.add(button);		
 		background.add(button2);
		this.setSize(728,910);
	} // end of constructor
}
