package myProj;
/**
 * this class represents content objects which have title image text and a creator
 */
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Content {
	public static ArrayList<Content> contents = new ArrayList<>();
    private String title;
    String timeOfCreation;
    private String image;
    private String text;
    private String nickname;
    private User user;
    
   
    public Content(User user, String title, String text, String image) {
    		this.title = title;
    		this.text = text;
    		this.image = image;
    		this.nickname = user.getNickname();
            setTimeOfCreation(); 
            this.user = user;
    }
    
    
    
    public User getUser() {
    	return user;
    }
    public String getCreator() {
    	return nickname;
    }
    public void setImage(String image) {
    	this.image = image;
    }
    public void setText(String text) {
    	this.text = text;
    }
    public String getImage() {
    	return image;
    }
    public String getText() {
    	return text;
    }
    public void setTitle(String title) {
    	this.title = title;
    }
    public String getTitle() {
    	return title;
    }
    public void setTimeOfCreation() {
    timeOfCreation =  LocalDateTime.now().toString(); 
    }
    public String getTimeOfCreation() {
    	return timeOfCreation;
    }
    
    //this method adds this content to the user contents the create content button in homepage uses this
    public void addContenttoUser() {
    	user.contents.add(this);
    	Content.contents.add(this);
    }
    
    //this method adds this content to the group contents the create content button in group page uses this
    public void addContenttoGroup(Group group) {
    		group.addContent(this);
    		Content.contents.add(this);
    		//when a content is added to a group, it is automatically added to the user too
    		user.contents.add(this);
    	}
    	
    }

