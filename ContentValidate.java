package myProj;
/**this class validates the
 * created content using its title image path string and text
 * @author beril
 *
 */
public class ContentValidate {
	public void validateCreatedContent(ContentCreator contentCreator) throws InvalidContentException{
		for(Content a: Content.contents) {
			if(contentCreator.title.getText().equals(a.getTitle())) {
				throw new InvalidContentException("Write another title!");
			}
		}
		
		if(contentCreator.title.getText().equals("")) {
			throw new InvalidContentException("Title is empty!");
		}
		
		if((contentCreator.text.getText().equals(""))&&(contentCreator.image == null)) {
			throw new InvalidContentException("Content has to have at least a text or an image");
		}
		
		
	}
	
	
	
	
}
