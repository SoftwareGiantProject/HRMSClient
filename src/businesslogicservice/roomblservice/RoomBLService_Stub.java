package businesslogicservice.roomblservice;

import util.RoomConditon;
import vo.RoomConditionDateVO;
import vo.RoomVO;

public class RoomBLService_Stub implements RoomBLService{

	String Room_type;
	int Room_num;
	double Room_price;
	String Room_number;
	RoomConditon Room_condition;
	String Hotel_id;

	
	public RoomBLService_Stub(String rt, int rn, double rp, String rnb, RoomConditon rc, String hi){
		this.Room_type = rt;
		this.Room_num = rn;
		this.Room_price = rp;
		this.Room_number = rnb;
		this.Room_condition = rc;
		this.Hotel_id = hi;
	}
	
	public RoomVO addRoom(RoomVO room_info){
		return room_info; 
	}
	
	public RoomVO checkOut(RoomVO room_info){
		this.Room_num += room_info.getRoomNum();		
		return new RoomVO(room_info.getRoomType(), this.Room_num, room_info.getRoomPrice(), room_info.getRoomNumber(), room_info.getRoomCondition(), room_info.getHotel_id());
	}
	
	public RoomVO reserve(RoomVO room_info){
		this.Room_num -= room_info.getRoomNum();
		return new RoomVO(room_info.getRoomType(), this.Room_num, room_info.getRoomPrice(), room_info.getRoomNumber(), room_info.getRoomCondition(), room_info.getHotel_id());
	}
	
	public RoomConditon getRoomCondition(RoomConditionDateVO room_condition){
		
		return room_condition.getRoomCondition();
	}
	
}
 

