package myProj;
/** 
 * this class creates a page to edit the chosen content. the entered info is used to update 
 * the content object
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

public class EditContentPage extends JFrame {
	
	JTextField editText;
	JTextField editImage;
	JButton editNow;
	
    JFileChooser fc;
    File file = null;
    
    JLabel textLabel;
    JLabel imageLabel;
	
	public EditContentPage(Content content) {
		setLayout(null);
		editText = new JTextField(content.getText());
		editImage = new JTextField(content.getImage());
		editNow  = new JButton("Edit now");
		
		editText.setBounds(130,100,200,60);
		editImage.setBounds(130,170,200,30);
		editNow.setBounds(130,350,150,30);
		
		textLabel = new JLabel("Edit text");
		textLabel.setBounds(20,100,100,30);
		imageLabel = new JLabel("Change image");
		imageLabel.setBounds(20,170,100,30);
		
		JButton chooseFile = new JButton("Choose new image");
		chooseFile.setBounds(20, 220, 250, 30);
		
		editNow.addActionListener(
				new ActionListener() // anonymous inner class
				{ 
					@Override
					public void actionPerformed(ActionEvent arg0) {
					
						if(file != null) {
							content.setImage(file.getPath());
						}
						if((editImage.getText().equals(""))&& (file == null)){
							content.setImage(null);
						}
						    content.setText(editText.getText());
						    
						    JOptionPane.showMessageDialog(null,"Content edited!");
						    MyProfile neww = new MyProfile(ProfilePage.OurUser);
							Homepage.main.newPage(neww);
						    setVisible(false);
						}	
					
						// will be executed every time the button is pressed.

					
				} // end anonymous inner class
		);
		
		
		
        //Create a file chooser
        fc = new JFileChooser();
		
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
				                
				                }						
					}
				} // end anonymous inner class
					
		); 
		add(editText);
		add(editImage);
		add(editNow);
		add(textLabel);
		add(imageLabel);
		add(chooseFile);
		setSize(450,750);
		setVisible(true);
	}
}
