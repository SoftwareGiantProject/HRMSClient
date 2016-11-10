package businesslogic.userbl;

public class MockClient extends Client{
	String user_id;
	String username;
	String contact;
	String birthday;
	String password;
	
	public MockClient(){
		
	}
	
	public MockClient(String userid,String username,String contact,String password,String birthday){
		this.user_id=userid;
		this.username=username;
		this.contact=contact;
		this.password=password;
		this.birthday=birthday;
	}
	public MockClient(String userid){
	    user_id=userid;
	}
	
	
	
	
	
	
	public String getUserid(){
		return user_id;
	}
	
	

	public String getClientBirthday(String user_id) {
		// TODO Auto-generated method stub
		return birthday;
	}
	
	public String getPassword(String user_id){
		return password;
	}
	
	public String getContact(String user_id){
		return contact;
	}

	public boolean isMember(String user_id) {
		// TODO Auto-generated method stub
		return false;
	}

}