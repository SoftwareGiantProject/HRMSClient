package vo;

import java.util.Date;

import javafx.beans.property.SimpleStringProperty;
import util.RoomCondition;

public class RoomConditionDateVO {
	
	//日期
	private SimpleStringProperty RoomDate;
	
	//酒店id
	private SimpleStringProperty hotel_id;
		
	//房间号
	private SimpleStringProperty RoomNumber;
		
	//房间状态״̬
	private RoomCondition roomcondition;
	
	//订单编号
	private SimpleStringProperty order_id;
		
	public RoomConditionDateVO(){
			
	}
		
	public RoomConditionDateVO(String rd, String rn, RoomCondition rc, String hi, String or){
	    	
	    RoomDate = new SimpleStringProperty(rd);
	    RoomNumber = new SimpleStringProperty(rn);
	    roomcondition = rc;
	    hotel_id = new SimpleStringProperty(hi);
	    order_id = new SimpleStringProperty(or);
			
	}
	
	
	    
	public SimpleStringProperty getOrder_id() {
		return order_id;
	}

	public SimpleStringProperty getRoomDate(){
	    return RoomDate;
	}
	    
	public SimpleStringProperty getRoomNumber(){
	    return RoomNumber;
	}
	    
	public RoomCondition getRoomCondition(){
	    return roomcondition;
	}
	
	public void setRoomDate(String roomDate) {
		RoomDate = new SimpleStringProperty(roomDate);
	}

	public void setHotel_id(String hotel_id) {
		this.hotel_id = new SimpleStringProperty(hotel_id);
	}

	public void setRoomNumber(String roomNumber) {
		RoomNumber = new SimpleStringProperty(roomNumber);
	}

	public void setRoomcondition(RoomCondition roomcondition) {
		this.roomcondition = roomcondition;
	}

	public void setOrder_id(String order_id) {
		this.order_id = new SimpleStringProperty(order_id);
	}

	public SimpleStringProperty getHotelId(){
		return hotel_id;
	}

}
