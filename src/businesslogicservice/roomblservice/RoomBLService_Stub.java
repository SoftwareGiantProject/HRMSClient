package businesslogicservice.roomblservice;

import util.RoomConditon;
import vo.RoomConditionDateVO;
import vo.RoomVO;

public class RoomBLService_Stub implements RoomBLService{

	String Room_type;
	int Room_num;
	double Room_price;
	
	public RoomBLService_Stub(String rt, int rn, double rp){
		this.Room_type = rt;
		this.Room_num = rn;
		this.Room_price = rp;
	}
	
	public RoomVO addRoom(RoomVO room_info){
		return room_info; 
	}
	public RoomVO checkOut(RoomVO room_info){
		this.Room_num += room_info.getRoomNum();
		return new RoomVO(room_info.getRoomType(), this.Room_num, room_info.getRoomPrice());
	}
	public RoomVO reserve(RoomVO room_info){
		this.Room_num -= room_info.getRoomNum();
		return new RoomVO(room_info.getRoomType(), this.Room_num, room_info.getRoomPrice());
	}
	public RoomVO getRoomInfo(RoomVO room){
		return room;
	}

	@Override
	public RoomConditon getRoomCondition(RoomConditionDateVO room_condition) {
		// TODO Auto-generated method stub
		return null;
	}
}
 
