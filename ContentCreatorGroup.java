package myProj;
/**
 * this class uses the variables in content creator. This class additionally 
 * sets create button to add the content to group
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ContentCreatorGroup extends ContentCreator{

	ContentCreator thisCreator = this; 
	
	public ContentCreatorGroup(Group group){
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
						//after validating content the new content is created and added
						Content newContent = new Content(ProfilePage.OurUser,title.getText(),theText,theImage);
			            
			            newContent.addContenttoGroup(group);
			            JOptionPane.showMessageDialog(null,"New content created!");
			            thisCreator.setVisible(false);
			            GroupPage neww = new GroupPage(group);
						Homepage.main.newPage(neww);
					}
					catch(InvalidContentException e) {
						JOptionPane.showMessageDialog(null,e.getMessage());
					}
			            
				}
				
				
				
			} // end anonymous inner class
				
	); 
	
	}
	
}
