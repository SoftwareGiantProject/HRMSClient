package businesslogic.userbl;

public class MockNetsale extends Netsale{
	String user_id;
	String username;
	String contact;
	String birthday;
	
	public MockNetsale(){
		
	}
	
	public MockNetsale(String userid,String username,String contact,String password){
		this.user_id=userid;
		this.username=username;
		this.contact=contact;
	}
	
	public String getUserid(){
		return user_id;
	}
	
	
	
	public String getContact(String user_id){
		return contact;
	}


}
