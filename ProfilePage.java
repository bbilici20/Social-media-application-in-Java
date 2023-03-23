package myProj;
/**
 * profile page is the parent of all profile pages, all of the profile pages share these features:
 * name, surname, nickname,profile photo, account type
 * static user ourUser is the account we sign in, or the account we sign up. Many methods in this  
 * application use this static variable to operate
 * 
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;

public class ProfilePage extends JPanel {
	
	 JLabel profilePhoto;
	 ImageIcon photo;
	 JLabel total;
	 static User OurUser;
	 String nickname;
	 String name;
	 String surname;
	 String type;
	
	public ProfilePage(User user) {
		this.setLayout(null);
		photo = new ImageIcon(user.getProfilePhoto());
		Image image = photo.getImage(); // transform the image to scale it 
		Image newimg = image.getScaledInstance(250, 250,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		photo = new ImageIcon(newimg);
		
		profilePhoto=new JLabel(photo);
		profilePhoto.setBounds(20,40,250,250);
		
		
		nickname = user.getNickname();
		name = user.getName();
		surname = user.getSurname();
		if (user.isPremium(user)) {
			type = "Premium";
		}
		else {
			type = "Normal";
		}
		total = new JLabel("<html>Nickname: "+nickname+"<br/>Name: "+name+"<br/>Surname: "+
		surname+"<br/>User type: "+type+"</html>");
		
		total.setForeground(Color.BLACK);
		total.setFont(new Font("Serif", Font.PLAIN, 18));
		total.setBackground(Color.PINK);
		
		total.setBounds(20,290,250,150);
		add(total);
		add(profilePhoto);
		this.setSize(728,910);
		
		
		
		
	}
}
