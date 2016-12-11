package vo;

import java.util.Date;

import util.RoomCondition;

public class RoomConditionDateVO {
	
	//日期
	private String RoomDate;
	
	//酒店id
	private String hotel_id;
		
	//房间号
	private String RoomNumber;
		
	//房间状态״̬
	private RoomCondition roomcondition;
	
		
	public RoomConditionDateVO(){
			
	}
		
	public RoomConditionDateVO(String rd, String rn, RoomCondition rc, String hi){
	    	
	    RoomDate = rd;
	    RoomNumber = rn;
	    roomcondition = rc;
	    hotel_id = hi;
			
	}
	    
	public String getRoomDate(){
	    return RoomDate;
	}
	    
	public String getRoomNumber(){
	    return RoomNumber;
	}
	    
	public RoomCondition getRoomCondition(){
	    return roomcondition;
	}
	
	public String getHotelId(){
		return hotel_id;
	}

}
