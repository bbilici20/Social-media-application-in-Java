package myProj;
/**
 * this is the class for every user object. Every account has these features:
 * name,surname,nickname,age,email,password
 * 
 * static users contains every user created, premiums contain every premium user
 * followed contains the users we follow, mygroups contains the groups we are in,
 * contents contains the contents we created
 */
import java.io.File;
import java.util.*;

public class User {
	private String password;
	private String name;
	private String surname;
	private final String nickname;
	private String age;
	private String email;
	
	private static ArrayList<User> users = new ArrayList<User>();
	public static ArrayList<User> premiums = new ArrayList<>();
	
	//public ArrayList<String> hobbies = new ArrayList<String>();
	public ArrayList<User> followed = new ArrayList<>();
	public ArrayList<Group> Mygroups = new ArrayList<>();
	private String profilePhoto;
	public ArrayList<Content> contents = new ArrayList<>();
	
	

	public User(String name, String surname,String nickname,String age, String email, String password){
		this.name = name;
		this.surname = surname;
		this.nickname = nickname;
		this.age = age;
		this.email = email;
		this.password = password;
		
		
	}
	
	public static ArrayList<User> getUsers(){
		return users;
	}
	
	public Boolean isPremium(User user) {
		if(premiums.contains(user)) {
			return true;
		}
		else {
			return false;
		}
	}
	public String getProfilePhoto() {
		return profilePhoto;
	}
	public String getName() {
		return name;
	}	
	public String getSurname() {
		return surname;
	}	
	public String getPassword() {
		return password;
	}	
	public String getNickname() {
		return nickname;
	}
	public String getAge() {
		return age;
	}
	public String getEmail() {
		return email;
	}
	
	
	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto =profilePhoto;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	public void setPremium() {
		premiums.add(this);
	}
	public void unPremium() {
		premiums.remove(this);
	}
	
	public void addUser(User user) {
		users.add(user);
	}
	public void removeUser(User user) {
		users.remove(user);
	}
	public String toString() {
		return "User: "+nickname;
	}
	
	
	public void followUser(User user) {
		followed.add(user);
	}
	
	public void unfollowUser(User user) {
		followed.remove(user);
	}
	
	
}
