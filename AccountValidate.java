package myProj;
/**
 * this class validates the user object created via sign up. the nickname should be unique,
 * the password should be 7 digits long and contain at least one alphabetic character.
 * the methods in this class throw exception
 * @author beril
 *
 */
public class AccountValidate {
	public void validateUser(User user) throws InvalidAccountException{
		for (User user1: User.getUsers()) {
			if (user.getNickname().equals(user1.getNickname())){
			throw new InvalidAccountException("This nickname already exists!");
			}
		}
		
		String[] a = user.getNickname().split(" ");
		if(a.length>1) {
			throw new InvalidAccountException("Nickname should contain no spaces!");
		}
		
		if (user.getPassword().length() != 7) {
			throw new InvalidAccountException("Password should have 7 digits!");
		}
		
		if(user.getPassword().matches("[0-9][0-9][0-9][0-9][0-9][0-9][0-9]")) {
			throw new InvalidAccountException("Password should contain at least one letter!");
		}
		
		
		
	}
	
	public void validateFollowed(User user) throws InvalidAccountException{
		if(!user.followed.contains(user)) {
			throw new InvalidAccountException("This nickname already exists!");
		}
	}
	
	public void validateNickname(String nickname) throws InvalidAccountException{
		boolean exists = false;
		for(User theuser: User.getUsers()) {
			if(theuser.getNickname().equals(nickname)) {
				exists = true;
			}
		}
		if(!exists) {
			throw new InvalidAccountException("This user doesn't exist!");
		}
		
	}	
	
	public void validateEditPassword(String password) throws InvalidAccountException{
		if (password.length() != 7) {
			throw new InvalidAccountException("Password should have 7 digits!");
		}
		
		if(password.matches("[0-9][0-9][0-9][0-9][0-9][0-9][0-9]")) {
			throw new InvalidAccountException("Password should contain at least one letter!");
		}
	}
	
	public void validateNicknameToAdd(Group group,String nickname) throws InvalidAccountException {
		
		for(User u: group.getMembers()) {
			if(u.getNickname().equals(nickname)) {
				throw new InvalidAccountException("This user is already in this group!");
			}
		}
	}
	
	public void validateNicknameToRemove(Group group,String nickname) throws InvalidAccountException {
		
		boolean isHere = false;
		for(User u: group.getMembers()) {
			if(u.getNickname().equals(nickname)) {
				isHere = true;
			}
		}
		if(!isHere) {
			throw new InvalidAccountException("This user is not in this group!");
		}
	}
}
