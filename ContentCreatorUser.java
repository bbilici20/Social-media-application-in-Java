package myProj;
/**
 * this class uses the variables in contentcreator. This class additionally 
 * sets create button to add the content to the given user
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ContentCreatorUser extends ContentCreator{
	
	ContentCreator thisCreator = this; 
	
	public ContentCreatorUser(User user){
		super();
	
	Create.addActionListener(
			// An anonymous inner class is declared without a name 
			// and typically appears inside a method declaration.
			new ActionListener() // anonymous inner class
			{ 
				@Override
				public void actionPerformed(ActionEvent arg0) {		
					try {
						String theImage;
						if(file == null) {
							theImage = null;
						}
						else {
							theImage = file.getPath();
						}
						
						String theText;
						if(text.getText() == null) {
							theText = null;
						}
						else {
							theText = text.getText();
						}
						validateTheContent.validateCreatedContent(thisCreator);
			            Content newContent = new Content(user,title.getText(),theText,theImage);
			            
			            
			            newContent.addContenttoUser();
			            JOptionPane.showMessageDialog(null,"New content created!");
			            
			            thisCreator.setVisible(false);
					}
					catch(InvalidContentException e) {
						JOptionPane.showMessageDialog(null,e.getMessage());
					}
			            
			            
				}
			} // end anonymous inner class
				
	); 
	
	}
}
