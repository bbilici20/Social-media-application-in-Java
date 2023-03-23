package myProj;
/**
 * content page is the page displaying the contents. with the given content object, this class
 * creates the according content page using the variables
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
 
public class ContentPage extends JFrame{
	
	JLabel contentImage;
	ImageIcon photo;
	JLabel text;
	JLabel title;
	 static User OurUser;
	 JLabel nickname;
	 JLabel time;
	 String name;
	 String surname;
	 String type;
	 ContentPage thisPage = this;
	
	public ContentPage(Content content) {
		this.setLayout(null);
		
		if(content.getImage() != null) {
		photo = new ImageIcon(content.getImage());
		Image image = photo.getImage(); // transform the image to scale it 
		Image newimg = image.getScaledInstance(250, 250,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		photo = new ImageIcon(newimg);
		
		contentImage=new JLabel(photo);
		contentImage.setBounds(20,40,250,250);
		add(contentImage);
		}
		
		title = new JLabel(content.getTitle());
		title.setBounds(20,320,180,20);
		title.setFont(new Font("Serif", Font.PLAIN, 18));
		add(title);
		
		nickname = new JLabel(content.getCreator());
		nickname.setBounds(20,410,180,20);
		add(nickname);
		
		time = new JLabel("Content created: "+content.getTimeOfCreation());
		time.setBounds(20,450,300,20);
		add(time);
		
		if(content.getText() != null) {
		text = new JLabel(content.getText());
		text.setForeground(Color.BLACK);
		text.setFont(new Font("Serif", Font.PLAIN, 18));
		text.setBackground(Color.PINK);
		
		text.setBounds(20,325,800,80);
		add(text);
		}
		
		if(ProfilePage.OurUser.contents.contains(content)) {
			JButton Create = new JButton("Edit");
			Create.setBounds(350, 40, 90, 40);
			Create.addActionListener(
					// An anonymous inner class is declared without a name 
					// and typically appears inside a method declaration.
					new ActionListener() // anonymous inner class
					{ 
						@Override
						public void actionPerformed(ActionEvent arg0) {
							EditContentPage editor = new EditContentPage(content);
							setVisible(false);
							
							// will be executed every time the button is pressed.

						}
					} // end anonymous inner class
			); 
			add(Create);
			
			
			JButton delete = new JButton("Delete");
			delete.setBounds(350, 90, 90, 40);
			delete.addActionListener(
					// An anonymous inner class is declared without a name 
					// and typically appears inside a method declaration.
					new ActionListener() // anonymous inner class
					{ 
						@Override
						public void actionPerformed(ActionEvent arg0) {
							
							ProfilePage.OurUser.contents.remove(content);
							for(Group group:ProfilePage.OurUser.Mygroups) {
								if(group.contents.contains(content)) {
									group.contents.remove(content);
									
								}
						}
							Content.contents.remove(content);
							JOptionPane.showMessageDialog(null,"Content deleted!");
						    
							thisPage.setVisible(false);
							
				
							
							// will be executed every time the button is pressed.

						}
					} // end anonymous inner class
			); 
			add(delete);
			
		}
		
		this.setSize(650,900);
		setVisible(true);
	}
}
