package myProj;
/**
 * this is the JFrame for creating content. The entered informations are taken and be used for creating a content object
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ContentCreator extends JFrame{
	
	ContentValidate validateTheContent = new ContentValidate();
	JFileChooser fc;
	File file = null;
    JTextField image;
    JLabel label4 = new JLabel("Enter title:");
	JTextField title = new JTextField(20);
	JLabel label7;
	JLabel label5 = new JLabel("Enter text:");
	JTextField text = new JTextField(20);
	
	JButton Create = new JButton("Create!");
	
	JButton chooseFile = new JButton("Choose content image");
    
	public ContentCreator() {
		
		this.setLayout(null);
		
		label4.setBounds(10, 132, 100, 100);
		title.setBounds(110, 170, 130, 25);
		this.add(label4);
		this.add(title);
		
		
		label5.setBounds(10, 162, 100, 100);
		text.setBounds(110, 200, 130, 25);
		add(label5);
		add(text);
		
		chooseFile.setBounds(10, 250, 250, 20);
		Create.setBounds(10, 450, 250, 20);
		
        //Create a file chooser
        fc = new JFileChooser();
        
        
		add(chooseFile);
		add(Create);
		setVisible(true);
		setSize(300, 600);
		
		//file chooser
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
				                label7 = new JLabel("Selected file: "+file.getPath());
				                label7.setBounds(10,268,800,20);
								add(label7);
								
				            }						
					}
				} // end anonymous inner class
					
		); 
		
		
		
		
		
		
	}

}
