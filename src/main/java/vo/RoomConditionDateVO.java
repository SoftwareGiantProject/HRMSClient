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
	
	//订单编号
	private String order_id;
		
	public RoomConditionDateVO(){
			
	}
		
	public RoomConditionDateVO(String rd, String rn, RoomCondition rc, String hi, String or){
	    	
	    RoomDate = rd;
	    RoomNumber = rn;
	    roomcondition = rc;
	    hotel_id = hi;
	    order_id = or;
			
	}
	
	
	    
	public String getOrder_id() {
		return order_id;
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
	
	public void setRoomDate(String roomDate) {
		RoomDate = roomDate;
	}

	public void setHotel_id(String hotel_id) {
		this.hotel_id = hotel_id;
	}

	public void setRoomNumber(String roomNumber) {
		RoomNumber = roomNumber;
	}

	public void setRoomcondition(RoomCondition roomcondition) {
		this.roomcondition = roomcondition;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getHotelId(){
		return hotel_id;
	}

}
