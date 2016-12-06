package vo;

import java.util.Date;

import util.RoomCondition;

public class RoomConditionDateVO {
	
	//酒店id
	private String hotel_id;
	
	//房间预定住宿时间
	private String RoomDate;
			
	//房间编号
	private String RoomNumber;
	
	//房间状态״̬
	private RoomCondition roomcondition;
		
	public RoomConditionDateVO(){
			
	}
		
	public RoomConditionDateVO(String hotel_id,String rd, String rn, RoomCondition rc){
	    
		this.hotel_id = hotel_id;
	    this.RoomDate = rd;
	    this.RoomNumber = rn;
	    this.roomcondition = rc;
			
	}
	    
	public String getHotel_id() {
		return hotel_id;
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

}
