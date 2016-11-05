package businesslogic.userbl;

import util.ResultMessage;
import vo.HotelVO;

public class MockNetworker extends Networker{
	String user_id;
	String username;
	String contact;
	String birthday;
	
	public MockNetworker(){
		
	}
	
	public MockNetworker(String userid,String username,String contact,String password){
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
	
	public ResultMessage addHotel(HotelVO vo){
		return ResultMessage.SUCCESS ;
	}

}
