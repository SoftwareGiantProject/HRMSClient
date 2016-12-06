package businesslogicservice.roomblservice;

import util.RoomCondition;
import vo.*;

public interface RoomBLService {

	public RoomVO addRoom(RoomVO room_info);
	public RoomVO checkOut(RoomVO room_info);
	public RoomVO reserve(RoomVO room_info);
	public RoomCondition getRoomCondition(RoomConditionDateVO room_condition);

}
