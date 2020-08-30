/*
 * Name: Shiyun Lian
 */
public class Profile {
	private String name;
	private String status;
	private DictionaryInterface<String, String> friendList = new LinkedDictionary<>();
	
	public Profile() {}
	
	public Profile(String name, String status, DictionaryInterface<String, String> friendList) {
		super();
		this.name = name;
		this.status = status;
		this.friendList = friendList;
	}

	public Profile(String name, String status) {
		super();
		this.name = name;
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public void addFriend(Profile personProfile) {
		friendList.add(personProfile.getName(), personProfile.getStatus());
	}
	
	public void deleteFriend(Profile personProfile) {
		if(friendList.contains(personProfile.name)) {
			friendList.remove(personProfile.getName());
		}
		else {
			System.out.println("No such friend in this profile");
		}
	}

}
