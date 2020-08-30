/*
 * Name: Shiyun Lian
   Name: Jinmei Wu

 */

import java.util.Iterator;
import java.util.Scanner;

public class ProfileList {
	Scanner input = new Scanner(System.in);
	private DictionaryInterface<String, String> profileList = new LinkedDictionary<>();
	
	public ProfileList() {
	}
	
	// add profile according to name and status
	public Profile addProfile(String name, String status) {
		Profile personProfile = new Profile(name, status);
		profileList.add(name, status);
		return personProfile;
	}
	
	// add profile according to object Profile
	public Profile addProfile(Profile personProfile) {
		profileList.add(personProfile.getName(), personProfile.getStatus());
		return personProfile;
	}
	
	// print a profilelist
	public void printProfileList() {
		Iterator<String> keyIterator = profileList.getKeyIterator();
		while (keyIterator.hasNext())
			System.out.println(keyIterator.next());
		System.out.println();
	}
	
	// read profile according to name
	public boolean readProfile(String name) {
		boolean IsSuccess = false;
		if(profileList.getValue(name)!= null) {
			System.out.println("The profile name is " + name);
			System.out.println("The status is " + profileList.getValue(name));
			IsSuccess = true;
		}
		return IsSuccess;
	}
	
	// read profile according to object Profile
	public void readProfile(Profile personProfile) {
		System.out.println("The profile name is " + personProfile.getName());
		System.out.println("The status is " + personProfile.getStatus());
		/*
		 * if(FriendList.contains(profile.getName())) {
			return FriendList.getValue(profile.getName());
		}
		else {
			return "No profile is found!";
		}
		 */	
	}
	
	// update profile according to name
	public boolean updateProfile(String name) {
		boolean isUpdate = false;
		if(profileList.getValue(name)!= null) {
			String status = profileList.getValue(name);
			Profile personProfile = new Profile(name, status);
			profileList.remove(name);
			System.out.println("Please enter new name:");
			String newName = input.next();
			personProfile.setName(newName);
			System.out.println("Please enter new status:");
			String newStatus = input.next();
			personProfile.setStatus(newStatus);
			System.out.println("The profile has been updated!");
			profileList.add(newName, newStatus);
			isUpdate = true;
		}
		else {
			System.out.println("No profile was found!");
		}
		return isUpdate;
	}
	
	// update profile according to object Profile
	public boolean updateProfile(Profile personProfile) {
		boolean isUpdate = false;
		if(profileList.contains(personProfile.getName())) {
			System.out.println("Please enter new name:");
			String newName = input.next();
			personProfile.setName(newName);
			System.out.println("Please enter new status:");
			String newStatus = input.next();
			personProfile.setStatus(newStatus);
			System.out.println("The profile has been updated!");
			isUpdate = true;
		}
		else {
			System.out.println("No profile was found!");
		}
		return isUpdate;
	}
	
	
	// delete profile according to object Profile
	public boolean deleteProfile(Profile personProfile) {
		boolean isDelete = false;
		if(profileList.contains(personProfile.getName())) {
			profileList.remove(personProfile.getName());
			isDelete = true;
			System.out.println("The profile has been deleted!");
		}
		else {
			System.out.println("No profile was found!");
		}
		return isDelete;
	}
	
	
	// delete profile according to name
	public boolean deleteProfile(String name) {
		boolean isDelete = false;
		if(profileList.getValue(name)!= null) {
			profileList.remove(name);
			isDelete = true;
			System.out.println("The profile has been deleted!");
		}
		else {
			System.out.println("No profile was found!");
		}
		return isDelete;
	}
	
	
	
	// check if the profile exists in profile list
	public boolean profileFound(String name) {
		boolean isFound = false;
		if(profileList.contains(name)) {
			isFound = true;
		}
		return isFound;
	}
	
	// retrieve the profile according to the name
	public Profile getProfile(String name) {
		if (profileList.contains(name)) {
			String status = profileList.getValue(name);
			Profile personProfile = new Profile (name, status);
			return personProfile;
		}
		else
			return null;
	}
}
