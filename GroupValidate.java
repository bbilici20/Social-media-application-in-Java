package myProj;
/**
 * validates group, group name and member name for different purposes
 * @author beril
 *
 */

public class GroupValidate {
	
//to validate the group name written to search for new group
public void validateGroupName(String groupName) throws InvalidGroupException{
	boolean exists = false;
	for(Group group: Group.allGroups) {
		if(group.name.equals(groupName)) {
			exists = true;
		}
	}
		if(!exists) {
			throw new InvalidGroupException("This group doesn't exist!");
		}
	}

//validate the created group
public void validateCreatedGroup(String groupName, String[] nameList) throws InvalidGroupException{
	boolean exist = false;
	for(Group g:Group.allGroups) {
		if(g.name.equals(groupName)) {
			throw new InvalidGroupException("Choose another group name!");
		}
	}
	if(groupName.equals("")) {
		throw new InvalidGroupException("Group name can't be empty!");
	}
	if(nameList.equals(null)) {
		throw new InvalidGroupException("You should add someone to your group");
	}
	
	for(String name:nameList) {
		for(User u:User.getUsers()) {
			if(u.getNickname().equals(name)) {
				exist = true;
			}
		}
		
	}
	if(!exist) {
		throw new InvalidGroupException("Invalid member nickname");
	}
}

}
