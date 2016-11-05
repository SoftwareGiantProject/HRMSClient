package businesslogicservice.roomblservice;

import util.RoomConditon;
import vo.*;

public interface RoomBLService {

	public RoomVO addRoom(RoomVO room_info);
	public RoomVO checkOut(RoomVO room_info);
	public RoomVO reserve(RoomVO room_info);
	public RoomVO getRoomInfo(RoomVO room);
	RoomConditon getRoomCondition(RoomConditionDateVO room_condition);

}
