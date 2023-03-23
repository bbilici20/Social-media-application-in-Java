package myProj;
/**
 * this is the class for group objects. contents contains the total contents for this group
 * member contains the members of this group
 * static variable allgroups contains all of the groups created till now
 */
import java.util.ArrayList;

public class Group {
	public ArrayList<Content> contents = new ArrayList<>();
	private ArrayList<User> members = new ArrayList<>();
	public String name;
	public static ArrayList<Group> allGroups = new ArrayList<>();
	public User creator;
	public String hobbies;
	public String country;
	
	public Group(User creator, ArrayList<User> members, String name, String hobbies, String country) {
		this.creator = creator;
		this.name = name;
		this.members = members;
		this.country = country;
		this.hobbies = hobbies;
		allGroups.add(this);
		for(User user:members) {
			user.Mygroups.add(this);
		}
	}
	
	public void addMember(User user) {
		members.add(user);
	}
	public ArrayList<User> getMembers(){
		return members;
	}
	
	public void addContent(Content content) {
		this.contents.add(content);
	}
	
	public void removeMember(User user) {
		members.remove(user);
	}
	
}
