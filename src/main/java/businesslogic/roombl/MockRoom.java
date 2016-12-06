
package businesslogic.roombl;

import util.RoomCondition;
import vo.RoomConditionDateVO;
import vo.RoomVO;

public class MockRoom{
	
	String Room_type;		
	int Room_num;		
	double Room_price;	
	String Room_number;		
	RoomCondition Room_condition;
	String Hotel_id;
	
	public MockRoom(){
		
	}

	public MockRoom(String rt, int rn, double rp, String rnb, RoomCondition rc, String ho){
		
		Room_type = rt;
		Room_num = rn;
		Room_price = rp;
		Room_number = rnb;
		Room_condition = rc;
		Hotel_id = ho;
		
	}
	
	public String getRoom_type(){
		return Room_type;
	}
	
	public int getRoom_num(){
		return Room_num;
	}
	
	public double getRoom_price(){
		return Room_price;
	}
	
	public String getRoom_number(){
		return Room_number;
	}
	
	public RoomCondition getRoom_condition(){
		return Room_condition;
	}
	
	public String getHotel_id(){
		return Hotel_id;
	}
	
	
	public RoomVO addRoom(RoomVO room_info){
		return null; 
	}
	
	public RoomVO checkOut(RoomVO room_info){
		return null;
	}
	
	public RoomVO reserve(RoomVO room_info){
		return null;
	}
	
	public RoomCondition getRoomCondition(RoomConditionDateVO room_condition){
		
		return null;
	}
	
}
